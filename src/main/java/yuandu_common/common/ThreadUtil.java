package yuandu_common.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 线程工具类
 * 
 * @author caozj
 *
 */
public class ThreadUtil {

	private static final Logger logger = LogManager.getLogger(ThreadUtil.class);

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			logger.error("休眠失败", e);
		}
	}

}
