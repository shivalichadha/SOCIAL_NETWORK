package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Blog;
import com.model.BlogComments;
import com.model.Forum;
import com.model.Group;
import com.service.BlogDaoService;
import com.service.ForumService;
import com.service.GroupDaoService;
@Controller
public class GroupBlogChatController {
	
	static Forum forum;
	
	static ArrayList<String> topicsList=new ArrayList<String>();
	@Autowired
	ServletContext context; 
	public GroupBlogChatController(){
		
	}
	@Autowired
	GroupDaoService gservice;
	public GroupBlogChatController(GroupDaoService gservice){
		this.gservice=gservice;
	}
	@Autowired
	BlogDaoService bservice;
	public GroupBlogChatController(BlogDaoService bservice){
		this.bservice=bservice;
	}
	@Autowired
	ForumService fservice;
	public GroupBlogChatController(ForumService fservice){
		this.fservice=fservice;
	}
	
	
	//---------------------GROUPS-------------------------------------------------------------------
	@RequestMapping("/groups")
	public String showGroupPage(ModelMap model){
		List<Group>groupList=gservice.viewAllGroups();
		model.addAttribute("groupList",groupList);
		return "groupsPage";		
	}
	@RequestMapping("/addGroupPage")
	public ModelAndView showAddGroupPage(){			
		return new ModelAndView("addGroupPage","group",new Group());		
	}
	@RequestMapping("/addNewGroup")
	public String addGroup(@Valid @ModelAttribute("group")
	Group group,BindingResult result){
		if(result.hasErrors()){
			System.out.println("adding a group has errors");
			return "addGroupPage";
		}
		else{
			System.out.println("--ADDING A GROUP---");
			System.out.println("group id:"+group.getGroupId());
			gservice.addGroup(group);
			String filename = null;
			System.out.println(context);	
			String path = context.getRealPath("/resources/" + group.getGroupId() + ".jpg");
			System.out.println("Path = " + path);
			System.out.println("File name = " + group.getGroupImage().getOriginalFilename());
			File f = new File(path);
			if (!group.getGroupImage().isEmpty()) {
				try {
					
						filename=group.getGroupImage().getOriginalFilename(); 
						byte[]bytes=group.getGroupImage().getBytes();
						BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
						bs.write(bytes);
						bs.close();
						System.out.println("Image uploaded");
					
						//System.out.println("Data Inserted"+(res++));
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			} 
			return "groupsPage";			
		}	
	}
	@RequestMapping("/deleteGroup")
	public String	deleteGroup(@RequestParam("groupId")String groupId,Model model){
		System.out.println("--deleting group---");
		gservice.deleteGroup(Integer.parseInt(groupId));		
		//List<Group>groupList=gservice.viewAllGroups();
		//model.addAttribute("groupList",groupList);
		return "groupsPage";		
	}
	//-----------------------BLOGS------------------------------------------------------------------------
	@RequestMapping("/blogs")
	public String showBlogsPage(ModelMap model ){		
		List<Blog>blogList=bservice.viewAllBlogs();
		model.addAttribute("blogList",blogList);
		return "blogsPage";
	}
	@RequestMapping("/addBlog")
	public ModelAndView showAddBlogPage(){		
		return new ModelAndView("addBlog","blog",new Blog());
	}
	@RequestMapping("/addNewBlog")
	public String addNewBlog(@Valid @ModelAttribute("blog")Blog blog , BindingResult result){		
		if(result.hasErrors()){
			System.out.println("adding a blog has errors");
			return "addBlog";
		}
		else{
			System.out.println("----ADDING A BLOG---------");
			bservice.addBlog(blog);
			return "blogsPage";
		}	
	}
	@RequestMapping("/searchBlog")
	public String searchBlog(@RequestParam("blogTitle")String blogTitle ,ModelMap model){
		System.out.println("----searching blog-----------");
		Blog blog=bservice.searchBlogByTitle(blogTitle);
		model.addAttribute("blog",blog);	
		return "blogsPage";
	}
	@RequestMapping("/postcomment")
	public String addComment(@ModelAttribute("comment")BlogComments comments,@RequestParam("comments") String c,@RequestParam("blogId")String blogId ,ModelMap model){
		System.out.println("----posting comment-----------");
		int bid=Integer.parseInt(blogId);
		List<BlogComments>blogComments=new ArrayList<BlogComments>();
		BlogComments bg=new BlogComments();
		bg.setComment(c);
		blogComments.add(bg);
		bservice.addComments(blogComments, bid);
		//model.addAttribute("blog",blog);	
		return "blogsPage";
	}
	//--------------------forums------------------------------------------------------------------------------
	@RequestMapping("/forums")
	public String showForumsPage(ModelMap model){
		List<Forum>forumList=fservice.viewAllForums();
		model.addAttribute("forumList",forumList);		
		return "forumsPage";	
	}	
	@RequestMapping("/addTopicPage")
	public ModelAndView showAddTopicPage(){			
		return new ModelAndView("addTopicPage","forum",new Forum());		
	}
	@RequestMapping("/adminPage")
	public String showAdminApproval(){			
		return "adminApproval";		
	}
	@RequestMapping("/approvals")
	public String showApprovals(@RequestParam("check")String var ){	
		//if forum is approved by admin then add forum in h2
		if(var.equals("yes")){
			fservice.addForum(forum);
		}		
		return "forumsPage";		
	}
	@RequestMapping("/addNewTopic")
	public String showForumsPage(@Valid@ModelAttribute("forum")Forum forum,BindingResult result){
		if(result.hasErrors()){
			System.out.println("errors");
			return "addTopicPage";			
		}			
		else{
			String topic=forum.getTopic();
			topicsList.add(topic);
			context.setAttribute("topicApprovalRequests",topicsList);
			//fservice.addForum(forum);
			this.forum=forum;
			return "redirect://index";
		}	
		
	}
	@RequestMapping("/deleteForum")
	public String	deleteForum(@RequestParam("topicId")String topicId,Model model){
		System.out.println("--deleting forum---");
		fservice.deleteForum(Integer.parseInt(topicId));		
		//List<Group>groupList=gservice.viewAllGroups();
		//model.addAttribute("groupList",groupList);
		return "forumsPage";		
	}
	
	//--------------------chat--------------------------------------------------------------------------------	
	@RequestMapping("/chat")
	public String showChatJoinPage(){
		return "chatJoinPage";
		
	}
	@RequestMapping("/application")
	public String showChatPage(){
		return "application";
		
	}
	
}
