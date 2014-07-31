package cn.ggs.abase.thread.book;

import java.util.ArrayList;
import java.util.List;

/**
 * Data structure for a web crawler. Keeps track of the visited sites and keeps
 * a list of sites which needs still to be crawled.
 */
public class CrawlerSyn {
	private List<String> linkedList = new ArrayList<String>();
	private List<String> crawledList = new ArrayList<String>();
	
	public void add(String site) {
		synchronized(this) {
			if(!crawledList.contains(site)) {
				linkedList.add(site);
			}
		}
	}

	/*
	 * Get next site to crawl. Can return null (if nothing to crawl)
	 */
	public String next() {
		if (linkedList.size() == 0) {
			return null;
		}
		
		synchronized(this) {
		// Need to check again if size has changed
			if(linkedList.size() > 0) {
				String site = linkedList.get(0);
				linkedList.remove(0);
				crawledList.add(site);
				return site;
			}
		}	
		return null;
	}
	
}
