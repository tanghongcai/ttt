package com.newer.blog.web.control;

import com.newer.blog.data.entity.TblBlog;
import com.newer.blog.util.BizResult;
import com.newer.blog.util.PageBean;
import com.newer.blog.web.service.IBlogService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BlogControl {
    @Resource
    IBlogService service;

    @RequestMapping(value = "deleteId",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> delete(@RequestBody String id)throws UnsupportedEncodingException{
        System.out.println("控制器方法启动");
        String myId= URLDecoder.decode(id,"utf-8");
        System.out.println("原始字符："+myId);
        int pos=myId.lastIndexOf("=");
        String result=myId.substring(0,pos);
        System.out.println("启动控制器删除"+result);
        JSONObject jsonObject=JSONObject.fromObject(result);
        String blogId=jsonObject.getString("id");
        boolean isFlag=this.service.deleteBlog(new Integer(blogId));
        System.out.println("按编号删除博客结果："+isFlag);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",isFlag);
        return map;
    }

    @RequestMapping(value = "queryId",method = RequestMethod.GET)
    public @ResponseBody TblBlog queryId(String id)throws UnsupportedEncodingException{
        System.out.println("控制器传递博客编号为："+id);
        TblBlog blog=this.service.queryId(new Integer(id));
        System.out.println("按编号查询的博客信息："+blog.toString());
        return blog;
    }
    @RequestMapping(value = "updateBlog",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateBlogVue(@RequestBody String content)throws UnsupportedEncodingException{
        System.out.println("控制器方法启动");
        String myContent= URLDecoder.decode(content,"utf-8");
        System.out.println("原始字符："+myContent);
        int pos=myContent.lastIndexOf("=");
        String result=myContent.substring(0,pos);
        System.out.println("启动控制器修改"+result);
        JSONObject jsonObject=JSONObject.fromObject(result);
        TblBlog blog= (TblBlog) JSONObject.toBean(jsonObject,TblBlog.class);
        System.out.println("json转换后的博客对象："+blog.toString());
        boolean isFlag=this.service.updateBlog(blog);
        System.out.println("控制器修改的结果为："+isFlag);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",isFlag);
        return map;
    }

    @RequestMapping(value = "addBlog1",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> addBlogVue(@RequestBody String content)throws UnsupportedEncodingException {
        System.out.println("控制器方法启动");
        String myContent= URLDecoder.decode(content,"utf-8");
        System.out.println("原始字符："+myContent);
        int pos=myContent.lastIndexOf("=");
        String result=myContent.substring(0,pos);
        System.out.println("启动控制器新增"+result);
        JSONObject jsonObject=JSONObject.fromObject(result);
        String blogContent=jsonObject.getString("content");
        System.out.println("新增博客内容："+blogContent);
        TblBlog blog=new TblBlog();
        blog.setBlogContent(blogContent);
        blog.setBlogCreateDate(new Date());
        boolean isSuccess=this.service.addBlog(blog);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("blog",blog);
        map.put("success",isSuccess);
        return map;
    }

    @RequestMapping(value = "getAllBlogs",method = RequestMethod.POST)
    public @ResponseBody List<TblBlog> queryAll(PageBean page){
        System.out.println("启动控制器全部查询");
        List<TblBlog> list=this.service.queryAll();
        return list;
    }

    @RequestMapping(value = "/newer",method = RequestMethod.GET)
    public @ResponseBody String blogCros(){
        System.out.println("启动方法：");
        return "welcome to newer";
    }

    @RequestMapping(value = "query",method = RequestMethod.GET)
    public @ResponseBody PageBean<TblBlog> query(PageBean page){
        System.out.println("启动控制器分页：");
        System.out.println("传递的页号："+page.getPageNo());
        System.out.println("传递的页大小："+page.getPageSize());
        PageBean<TblBlog> pb=this.service.queryReturnBlogPage(page.getPageNo(),page.getPageSize());
        return pb;
    }

    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    public @ResponseBody BizResult<?> addBlog(TblBlog blog){
        System.out.println("启动控制器新增：");
        BizResult<?> result=this.service.insertBlog(blog);
        return result;
    }

    @RequestMapping(value = "query.do",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> queryPage(PageBean page){
        System.out.println("启动控制器分页：");
        System.out.println("传递的页号："+page.getPageNo());
        System.out.println("传递的页大小："+page.getPageSize());

        PageBean<TblBlog> pa = this.service.queryReturnBlogPage(page.getPageNo(), page.getPageSize());

        Map<String,Object> param=new HashMap<>();
        System.out.println("控制器分页结果："+pa.toString());
        System.out.println("分页结果："+pa.getData().toString());
        param.put("list",pa);
        return param;
    }
}
