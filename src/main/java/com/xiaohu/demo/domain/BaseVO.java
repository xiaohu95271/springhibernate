package com.xiaohu.demo.domain;

import com.xiaohu.demo.common.DateUtil;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈实体类公共字段提取〉
 *
 * @author HuTao
 * @create 2019/7/10 14:42
 * @since 1.0.0
 */
@Data
@MappedSuperclass
public class BaseVO implements Serializable {
    private static final long serialVersionUID = -926874738132420619L;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid.hex")
    @Column(name = "id", unique = true, nullable = true)
    private String id;
    @Column(name="create_date")
    private String createDate = DateUtil.getDate(DateUtil.YYYY_MM_DD_HH_MM_SS);
    @Column(name="update_date")
    private String updateDate = DateUtil.getDate(DateUtil.YYYY_MM_DD_HH_MM_SS);
    @Column(name="status")
    private String status;
}
