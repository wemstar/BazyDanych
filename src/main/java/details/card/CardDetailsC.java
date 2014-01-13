package details.card;

import commons.Commons;
import commons.HibernateFunctions;
import entity.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by wemstar on 15.12.13.
 */
public class CardDetailsC {

    private CardDetailsV view;
    public void updateModel()
    {
        CardDetailsM model=view.getModel();

        model.type=view.getType();
        model.race=view.getRace();
        model.edition=view.getEdition();
        model.cost=view.getCost();
        model.addicionalCost=view.getAddicionalCost();
        model.strenght=view.getStrenght();
        model.defence=view.getDefence();
        model.count=view.getCount();
        model.subTypes=view.getSubTypes();
        model.action=view.getAction();
        model.name=view.getName();
    }

    public void updateView()
    {
        CardDetailsM model=view.getModel();

        view.setType(model.type);
        view.setRace(model.race);
        view.setEdition(model.edition);
        view.setCost(model.cost);
        view.setAddicionalCost(model.addicionalCost);
        view.setStrenght(model.strenght);
        view.setDefence(model.defence);
        view.setCount(model.count);
        view.setSubTypes(model.subTypes);
        view.setAction(model.action);
        view.setName(model.name);
        view.setImage(model.img);
        view.getMainPanel().updateUI();
    }

    public void castToModel(CardEntity entity)
    {
        CardDetailsM model=view.getModel();

        model.type=entity.getType()!=null ? entity.getType() : null;
        model.race=entity.getRace()!=null ? entity.getRace() : null;
        model.edition=entity.getEdition()!=null ? entity.getEdition() : null;
        model.cost=entity.getCost()!=null ? entity.getCost() : 0;
        model.addicionalCost=entity.getAddicionallcost()!=null ? entity.getAddicionallcost() : 0;
        model.strenght=entity.getStrenght()!=null ?entity.getStrenght() : 0 ;
        model.defence=entity.getDefence()!=null ? entity.getDefence():0;
        model.count=entity.getCount()!=null ? entity.getCount() : 0;
        model.subTypes=entity.getSubtypes()!=null?entity.getSubtypes():"";
        model.action=entity.getActions()!=null ? entity.getActions() : null;
        model.name=entity.getName();

        try {
            if(entity.getImage()!=null)
            {
                InputStream in = new ByteArrayInputStream(entity.getImage());
                model.img = ImageIO.read(in) ;
            }
            else
            {
                model.img=ImageIO.read(new File("/home/wemstar/BazyDanych/src/main/resources/default.jpg"));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
        }

        updateView();

    }
    public CardEntity castToEntity()
    {
        updateModel();
        CardDetailsM model=view.getModel();
        CardEntity entity=new CardEntity();


        entity.setName(model.name );
        entity.setType(model.type);
        entity.setRace(model.race);
        entity.setEdition(model.edition);
        entity.setCost(model.cost);
        entity.setAddicionallcost(model.addicionalCost);
        entity.setStrenght(model.strenght);
        entity.setDefence(model.defence);
        entity.setCount(model.count);
        entity.setSubtypes(model.subTypes);
        entity.setActions(model.action);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if(model.img!=null)
        {
            try {
                ImageIO.write( model.img, "jpg", baos );
                baos.flush();
                entity.setImage(baos.toByteArray());
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return entity;


    }
    public void setView(CardDetailsV view) {
        this.view = view;
    }

    public CardDetailsV getView() {
        return view;
    }

    public void saveCard() {

        updateModel();
        CardEntity entity= castToEntity();
        if(entity.getName().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Pole name nie może byc puste", "Wrong ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        HibernateFunctions.saveCard(entity);
    }

    public void loadFile(File selectedFile) {

        CardDetailsM model=view.getModel();
        try {
           model.img= ImageIO.read(selectedFile);
           System.out.println(selectedFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateView();
    }

    public void deleteCard() {
        if(Commons.currentUser.getRole().equals("admin"))HibernateFunctions.deleteCard(castToEntity());
    }
}
