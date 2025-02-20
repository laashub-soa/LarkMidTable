package com.larkmidtable.admin.mapper;

import com.larkmidtable.admin.entity.JobLog;
import com.larkmidtable.admin.entity.OperLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * job log
 *
 * @author xuxueli 2016-1-12 18:03:06
 */
@Mapper
public interface JobLogMapper {

    // exist jobId not use jobGroup, not exist use jobGroup
    List<JobLog> pageList(@Param("offset") int offset,
                          @Param("pagesize") int pagesize,
                          @Param("type") int type,
                          @Param("status") int status);

    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize,
                      @Param("type") int type,
                      @Param("status") int status);

    JobLog load(@Param("id") long id);

    long save(JobLog jobLog);

    int updateTriggerInfo(JobLog jobLog);

    int updateHandleInfo(JobLog jobLog);

    int updateProcessId(@Param("id") long id,
                        @Param("processId") String processId);

    int delete(@Param("jobId") int jobId);

    Map<String, Object> findLogReport(@Param("from") Date from,
                                      @Param("to") Date to);

    List<Long> findClearLogIds(@Param("jobGroup") int jobGroup,
                               @Param("jobId") int jobId,
                               @Param("clearBeforeTime") Date clearBeforeTime,
                               @Param("clearBeforeNum") int clearBeforeNum,
                               @Param("pagesize") int pagesize);

    int clearLog(@Param("logIds") List<Long> logIds);

    List<Long> findFailJobLogIds(@Param("pagesize") int pagesize);

    int updateAlarmStatus(@Param("logId") long logId,
                          @Param("oldAlarmStatus") int oldAlarmStatus,
                          @Param("newAlarmStatus") int newAlarmStatus);

	long writeLoinLog(@Param("ipAddr") String ipAddr, @Param("username")String username,
			@Param("operator")String operator,@Param("time")String time);

	List<OperLog> list(@Param("offset") int offset,
			@Param("pagesize") int pagesize);

	int listCount();
}
