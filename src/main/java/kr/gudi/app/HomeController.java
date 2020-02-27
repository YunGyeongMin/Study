package kr.gudi.app;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	
	@Autowired private SqlSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
//		int result = session.selectOne("sql.test");
//		System.out.println(result);
		model.addAttribute("list", session.selectList("sql.getData"));
		model.addAttribute("naver", session.selectList("sql.getNaverData"));
		
		return "home";
	}
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public RedirectView getData() throws IOException {
		
//		Connection conn = Jsoup.connect(url); //접속
//		Document dc = conn.get(); // 화면 가져오기
//		Elements eles = dc.select(".process-list .clearfix");// 원하는 class선택후 Elements에 넣는다
//		
//		Element ele = eles.get(0);
//		Elements lis = ele.select(".first_li");

		if(session.delete("sql.removeData") >= 0) {
			String url = "http://www.gdu.co.kr/process/process_010100.html";
			int tot = 1;
			for(int i = 1; tot != 0; i++) {
				String url2 = url + "?page=" + i;
				System.out.println("url2 : " + url2);
				Elements lis = Jsoup.connect(url2).get()
			            			.select(".process-list .clearfix").get(0)
			            			.select(".first_li");
				tot = lis.size();	
				for(Element li : lis) {
					Map<String, String> dataMap = new HashMap<String, String>();
					dataMap.put("title", li.select(".tit").text());
					dataMap.put("date", li.select(".date").text());
					dataMap.put("type", li.select(".type-img span").text());
					session.insert("sql.setData", dataMap);
				}
			}
			
		}
		return new RedirectView("/");
	}

	@RequestMapping(value = "/naverData", method = RequestMethod.GET)
	public RedirectView naverData() throws IOException {
//		String url = "https://section.blog.naver.com/BlogHome.nhn";
//		String url2 = url + "?directoryNo=0&currentPage=" + 1 + "&groupId=0";
//		Connection cn = Jsoup.connect(url2)
//		 					 .header("Origin", "https://section.blog.naver.com/BlogHome.nhn?directoryNo=0&currentPage=52&groupId=0")
//		 					 .header("Referer", "https://section.blog.naver.com/BlogHome.nhn?directoryNo=0&currentPage=52&groupId=0")
//		 					 .data("query", "쿼리").get();
//
//		System.out.println(url2);
//		Document dc = cn.get();
//		Elements divs = dc.select(".wrap_thumbnail_post_list .list_post_article .info_post");
//		System.out.println(divs.size());
//		
		System.out.println("안녕");
		if(session.delete("sql.removeNaverData") >= 0) {
			String url = "https://section.blog.naver.com/BlogHome.nhn";
			int tot = 1;
			for(int i = 1; tot != 0; i++) {
				System.out.println("반가워");
				String url2 = url + "?currentPage=" + i ;
				System.out.println("ur2 : " + url2);
				Elements divs = Jsoup.connect(url2).get()
									 .select(".wrap_thumbnail_post_list .list_post_article")
									 .select(".info_post");
				System.out.println("뭐가문제니");
				tot = divs.size();
				System.out.println(tot);
				for(Element div : divs) {
					Map<String, String> blogMap = new HashMap<String, String>();
					blogMap.put("name", div.select(".name_author").text());
					blogMap.put("title", div.select(".title_post").text());
					blogMap.put("content", div.select(".text").text());
					session.insert("sql.setNaverData", blogMap);
				}
			}
		}
		return new RedirectView("/");
	}
}
