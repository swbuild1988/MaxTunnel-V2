package com.bandweaver.maxtunnelcommon.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class FileUtil {

    /**
     * 判断文件是否存在
     * @param path
     * @return
     */
    public static boolean isExit(String path){
        File file = new File(path);
        return file.exists();
    }
    
    /**创建路径 
     * @param path   
     * @author shaosen
     * @Date 2018年8月29日
     */
    public static void createPath(String path){
    	File file = new File(path);
    	file.mkdirs();
    }

    /**
     * 返回html文件夹所在的目录
     * @return
     */
    public static String htmlDir(){
        String classePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        // 单纯去掉最后一个“/”，方便后面截取字符
        classePath = classePath.substring(0,classePath.lastIndexOf('/'));
        String htmlPath = classePath.substring(0,classePath.lastIndexOf('/')) + "/html";
        return  htmlPath;
    }

	/**
	 * @Description: 复制文件
	 * @param @param in
	 * @param @param out   
	 * @return void  
	 * @throws IOException 
	 * @throws
	 * @author shaosen
	 * @date 2018年7月5日
	 */
	public static void copyStream(InputStream in, OutputStream out) throws IOException {
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = in.read(buf)) != -1 ) {
			out.write(buf, 0, len);
		}
		//关闭流
		in.close();
		out.close();
	}
	
	
	
	/**读取文件中的内容 
	 * @param filePath 文件路径
	 * @return   
	 * @author shaosen
	 * @Date 2018年12月3日
	 */
	public static String readContent(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			int size = fis.available();
			byte[] array = new byte[size];
			fis.read(array);
			String result = new String(array);
			return result;
		} catch (FileNotFoundException e) {
			log.error(e.toString());
		} catch (IOException e) {
            log.error(e.toString());
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
                    log.error("io流关闭失败：" + e.toString());
				}
			}
		}
		return null;
	}
	
	
	/**写入文件 
	 * @param filePath 目标文件
	 * @param content  文件内容
	 * @author shaosen
	 * @Date 2018年12月3日
	 */
	public static void writeContent(String filePath,String content) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File(filePath)));
			bw.write(content);
		} catch (IOException e) {
            log.error(e.toString());
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
                    log.error("io流关闭失败：" + e.toString());
				}
			}
		}
		
		
	
		
	}

	
}
