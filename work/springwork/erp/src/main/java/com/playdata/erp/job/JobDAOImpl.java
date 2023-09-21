package com.playdata.erp.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobDAOImpl implements JobDAO {
	
	JdbcTemplate template;

	@Autowired
	public JobDAOImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public int insert(JobDTO job) {
		String sql = "insert into job values(?,?,?,?)";
		return template.update(sql, job.getJob_id(),job.getJob_name(),
				job.getJob_category(),job.getMenupath());
	}

	@Override
	public List<JobDTO> select() {
		return template.query("select * from job", new JobRowMapper());
	}

	@Override
	public int delete(String job_id) {
		return template.update("delete from job where job_id=?" ,new Object[] {job_id});
	}

	@Override
	public JobDTO read(String job_id) {
		// TODO Auto-generated method stub
		return template.queryForObject("select * from job where job_id=?" ,new Object[] {job_id}, new JobRowMapper());
	}

	@Override
	public int update(JobDTO job) {
		// TODO Auto-generated method stub
		System.out.println(job);
		String sql="update job set job_name=?, job_category=?, menupath=? where job_id=?";
		return template.update(sql, job.getJob_name(), job.getJob_category(), job.getMenupath(), job.getJob_id());
	}

}
