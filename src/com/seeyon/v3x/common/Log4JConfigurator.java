/**
 * 
 */
package com.seeyon.v3x.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

import com.seeyon.v3x.utils.ResourceLoadUtils;

/**
 *
 * @author <a href="mailto:tanmf@seeyon.com">Tanmf</a>
 * @version 1.0 2007-7-27
 */
public class Log4JConfigurator {
    public static final String LOG4J_CONFIG_FILE = "log4j.config.file";
    
    private static Log log;
    
    private static PropertyConfigurator log4jPropertyConfigurator;
    
    private static Properties p = new Properties();
    
    private static long lastModified;
    
    private static Date beginTime = null;
    
    private static Date endTime = null;
    
    private static boolean fileIsLoad = false; //配置文件加载标识位，false，表示不存在，true表示存在

    /**
     * 加载Log4j
     * @param log4jPath 如：classpath*:conf/Log4j.properties
     */
    public static void initialized() {
        InputStream input = ResourceLoadUtils.get(null, "classpath*:conf/Log4j.properties");
        
        if (input != null) {
            try {
                p.load(input);
                
                log4jPropertyConfigurator = new PropertyConfigurator();
                
                log4jPropertyConfigurator.doConfigure(p, LogManager.getLoggerRepository());
                
                log = LogFactory.getLog(Log4JConfigurator.class);
                log.info("A8 logging configured");
            }
            catch (Exception ioe)            {
                ioe.printStackTrace();
            }
            finally{
		        if(input != null){
		        	try {
						input.close();
					}
					catch (IOException e) {
					}
		        }
            }
        }
    }
    
    
    
}
