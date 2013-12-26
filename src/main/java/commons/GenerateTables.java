package commons;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by wemstar on 15.12.13.
 */
public class GenerateTables {

    public static void main(String[] args)
    {
        Configuration cfg=new Configuration();
        cfg.configure();

        SchemaExport se=new SchemaExport(cfg);

        se.create(true, true);
    }
}
