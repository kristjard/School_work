package data;

import services.PublicHolidayService;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Course {

   private String name;
   private Teatcher teacher;
   private ZonedDateTime start_date;
   private ZonedDateTime end_date;
   private int eap;

   private PublicHolidayService publicHolidayService = new PublicHolidayService();
   public Course(String name, Teatcher teacher, ZonedDateTime start_date, ZonedDateTime end_date, int eap) {
      this.name = name;
      this.teacher = teacher;
      this.start_date = start_date;
      this.end_date = end_date;
      this.eap = eap;
   }
   public Long getLength() {
      return ChronoUnit.DAYS.between(start_date, end_date) +1;
   }
   public String getName() {
      return name;
   }
   public Teatcher getTeacher() {
      return teacher;
   }
   public void setTeacher(Teatcher teacher) {
      this.teacher = teacher;
   }
   public ZonedDateTime getStart_date() {
      return start_date;
   }
   public ZonedDateTime getEnd_date() {
      return end_date;
   }
   public int getEap() {
      return eap;
   }
   public void setEap(int eap) {
      this.eap = eap;
   }

   public long getWorkingDays()  {
      if (end_date.isAfter(start_date)){

         final int startW = start_date.getDayOfWeek().getValue();
         final int endW = end_date.getDayOfWeek().getValue();

         final long days = ChronoUnit.DAYS.between(start_date, end_date) +1;
         long result = days - 2*(days/7);

         if (days % 7 != 0){
            if(startW == 7){result -= 1;}
            else if(endW == 7){result -= 1;}
            else if(endW < startW){result -= 2;}
         }

         return result - publicHolidayService.getPublicHolidaysOnWorkdays(start_date, end_date);
      }
      else{
         throw new IllegalArgumentException("nii ei saa");
      }
   }

   /*@Override
   public String toString() {
      return "Course{" +
              "name='" + name + '\'' +
              ", teacher=" + teacher +
              ", start_date=" + start_date +
              ", end_date=" + end_date +
              ", eap=" + eap +
              ", publicHolidayService=" + publicHolidayService +
              '}';
   }*/
}

