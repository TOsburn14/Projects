package com.techelevator;

public class HomeworkAssignment {



            //Variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;



            //Constructor
    public HomeworkAssignment (int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

            // Derived
    public String getLetterGrade(){
      double letterGrade = (double) this.earnedMarks / this.possibleMarks;
      if (letterGrade >= .90){
          return "A";
      } else if (letterGrade >= .80) {
          return "B";
      } else if (letterGrade >= .70) {
          return "C";
      } else if (letterGrade >= .60) {
          return "D";
      }else {
          return "F";
      }

    }


            //Getter
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

              //Setter
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }
}
