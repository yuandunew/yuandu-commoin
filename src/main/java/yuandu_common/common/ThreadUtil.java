package yuandu_common.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程工具类
 * 
 * @author caozj
 *
 */
public class ThreadUtil {

	private static final Logger logger = LoggerFactory.getLogger(ThreadUtil.class);

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			logger.error("休眠失败", e);
		}
	}

}
