package com.ljs.service.impl;

import com.ljs.dao.StudentDao;
import com.ljs.entity.Student;
import com.ljs.service.StudentService;

/**
 * create by ljs on 2020/6/15 15:23
 * <p>
 * description:
 */
public class StudentServiceImpl implements StudentService {


    StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Integer insertStudent(Student student) {

        return studentDao.insertStudent(student);

    }
}
