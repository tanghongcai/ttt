package com.newer.blog.web.service.Impl;

import com.newer.blog.data.dao.IBlogDAO;
import com.newer.blog.data.entity.TblBlog;
import com.newer.blog.util.BizResult;
import com.newer.blog.util.PageBean;
import com.newer.blog.web.service.IBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements IBlogService {
    @Resource
    IBlogDAO dao;

    @Override
    public boolean deleteBlog(Integer id) {
        System.out.println("删除博客业务");
        boolean isFlag=false;
        int count=this.dao.deleteByPrimaryKey(id);
        System.out.println("删除业务返回结果："+count);
        if(count>0){
            isFlag=true;
            System.out.println("业务层删除成功");
        }
        return isFlag;
    }

    @Override
    public TblBlog queryId(Integer id) {
        System.out.println("按编号查询博客业务，编号是："+id);
        TblBlog blog=this.dao.selectByPrimaryKey(id);
        System.out.println("查询的博客信息："+blog.toString());
        return blog;
    }

    @Override
    public boolean updateBlog(TblBlog blog) {
        System.out.println("修改博客业务");
        boolean isFlag=false;
        int count=this.dao.updateByPrimaryKeySelective(blog);
        System.out.println("修改业务返回结果："+count);
        if (count>0){
            isFlag=true;
            System.out.println("业务层修改成功");
        }
        return isFlag;
    }

    @Override
    public boolean addBlog(TblBlog blog) {
        System.out.println("新增博客业务");
        boolean isFlag=false;
        this.dao.insertBlog(blog);
        if (blog.getBlogId()>0){
            isFlag=true;
        }
        return isFlag;
    }

    @Override
    public List<TblBlog> queryAll() {
        System.out.println("全部查询业务");
        List<TblBlog> all=this.dao.selectAll();
        System.out.println("全部查询结果："+all.toString());
        return all;
    }

    @Override
    public BizResult<?> insertBlog(TblBlog blog) {
        System.out.println("添加信息");
        BizResult<TblBlog> result=new BizResult<TblBlog>();
        if (blog.getBlogCreateDate()==null){
            blog.setBlogCreateDate(new Date());//设置默认的时间
        }
        try {
            dao.insertBlog(blog);
            if (blog.getBlogId()>0){
                result.setSuccess(true);//新增成功
                result.setResult(blog);
            }else {
                result.setSuccess(false);//新增失败
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PageBean<TblBlog> queryReturnBlogPage(int pageNo, int pageSize) {
       PageBean<TblBlog> pb=new PageBean<TblBlog>();
       try {
           Map<String,Object> param=new HashMap<String,Object>();
           int start=(pageNo-1)*pageSize+1;
           int end=pageNo*pageSize;
           param.put("startIndex",start);
           param.put("endIndex",end);
           List<TblBlog> blog=dao.selectByPage(param);
           int totalCount=dao.getTotalCount();
           pb.setData(blog);
           pb.setTotalRecords(totalCount);
           pb.setPageNo(pageNo);
           pb.setPageSize(pageSize);
           System.out.println("业务层返回分页的结果："+pb.toString());
       }catch (Exception e){
           e.printStackTrace();
       }
        return pb;
    }
}
