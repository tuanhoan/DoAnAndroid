package com.example.lib.Models;

import java.io.Serializable;

public class ScoreModel implements Serializable {
    public int studentId;
    public int subjectId;
    public float mouthTest;
    public float test15m;
    public float test60m;
    public float oralTest;
    public float finalTest;
    public StudentModel studentNavigation;
    public SubjectModel subjectNavigation;

    public ScoreModel() {
    }

    public ScoreModel(int studentId, int subjectId, float mouthTest, float test15m, float test60m, float oralTest, float finalTest, StudentModel studentNavigation, SubjectModel subjectNavigation) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.mouthTest = mouthTest;
        this.test15m = test15m;
        this.test60m = test60m;
        this.oralTest = oralTest;
        this.finalTest = finalTest;
        this.studentNavigation = studentNavigation;
        this.subjectNavigation = subjectNavigation;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public float getMouthTest() {
        return mouthTest;
    }

    public void setMouthTest(float mouthTest) {
        this.mouthTest = mouthTest;
    }

    public float getTest15m() {
        return test15m;
    }

    public void setTest15m(float test15m) {
        this.test15m = test15m;
    }

    public float getTest60m() {
        return test60m;
    }

    public void setTest60m(float test60m) {
        this.test60m = test60m;
    }

    public float getOralTest() {
        return oralTest;
    }

    public void setOralTest(float oralTest) {
        this.oralTest = oralTest;
    }

    public float getFinalTest() {
        return finalTest;
    }

    public void setFinalTest(float finalTest) {
        this.finalTest = finalTest;
    }

    public StudentModel getStudentNavigation() {
        return studentNavigation;
    }

    public void setStudentNavigation(StudentModel studentNavigation) {
        this.studentNavigation = studentNavigation;
    }

    public SubjectModel getSubjectNavigation() {
        return subjectNavigation;
    }

    public void setSubjectNavigation(SubjectModel subjectNavigation) {
        this.subjectNavigation = subjectNavigation;
    }
}
