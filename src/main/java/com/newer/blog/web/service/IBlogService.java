package com.newer.blog.web.service;

import com.newer.blog.data.entity.TblBlog;
import com.newer.blog.util.BizResult;
import com.newer.blog.util.PageBean;

import java.util.List;

public interface IBlogService {
    //按编号删除
    public boolean deleteBlog(Integer id);
    //按编号修改
    public TblBlog queryId(Integer id);
    //按编号修改
    public boolean updateBlog(TblBlog blog);
    //新增
    public boolean addBlog(TblBlog blog);

    //全部查询
    public List<TblBlog> queryAll();

    BizResult<?> insertBlog(TblBlog blog);

    PageBean<TblBlog> queryReturnBlogPage(int pageNo,int pageSize);
}
