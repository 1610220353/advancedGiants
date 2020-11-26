package com.advanced.dome.multithread;


import java.net.InetSocketAddress;




import org.csource.fastdfs.*;




public class FastDFSUtil {


    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageClient storageClient = null;

	private InetSocketAddress[] tracker_servers;


	public FastDFSUtil() throws Exception {
		//链接超时时间
		ClientGlobal.setG_connect_timeout(3000);
		//网络超时时间
		ClientGlobal.setG_network_timeout(100000);
		//是否使用token
		ClientGlobal.setG_anti_steal_token(false);
		//设置字符集
		ClientGlobal.setG_charset("UTF-8");
		InetSocketAddress[] tracker_servers = getFastDFSInfo();

		this.tracker_servers = tracker_servers;

	}

	public InetSocketAddress[] getFastDFSInfo()  {


		String naCosValue = "192.168.248.197:22122";
		String[] hostport = naCosValue.split(",");
		InetSocketAddress[] tracker_servers = new InetSocketAddress[hostport.length];
		for (int i = 0; i < hostport.length; i++) {
			String node = hostport[i];
			String[] ipport = node.split(":");
			String nodeHost = ipport[0];
			int nodePort = Integer.parseInt(ipport[1]);
			tracker_servers[i] = new InetSocketAddress(nodeHost, nodePort);
		}
		return tracker_servers;
	}

    /**
     * 避免文件冲突，每次实例化一个StorageClient
     */
    private StorageClient getStorageClient() throws Exception {
		TrackerGroup tg = new TrackerGroup(tracker_servers);

        try {
            if (trackerClient == null) {
                trackerClient = new TrackerClient(tg);
            }

            if (trackerServer == null) {
                trackerServer = trackerClient.getConnection();
            }
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            if (storageServer == null) {
                throw new IllegalStateException("getStoreStorage return null");
            }
            if (storageClient == null) {
                storageClient = new StorageClient(trackerServer, storageServer);
            }

            return storageClient;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }


     public synchronized String download(String group_name, String remote_filename) throws Exception {
		byte[] bytes  = null;

            StorageClient storageClient = this.getStorageClient();

			bytes = storageClient.download_file(group_name, remote_filename);


        return bytes.toString();
    }

	public static void main(String[] args) {
		FastDFSUtil fastDFSUtil = null;
		try {
			fastDFSUtil = new FastDFSUtil();
			System.out.println(fastDFSUtil.download("group1", "M00/00/47/wKj4xV9h0R-ASgpfAAAAAAAAAAA5.1.txt"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}