package openclose;

class Main {

  public static void main(String[] args) {
    StudentCinema studentCinema = new StudentCinema(100.0);
    Double adminFeeStudent = studentCinema.calculateAdminFee();
    System.out.println("Admin Fee for Student Cinema: " + adminFeeStudent);
  }
}
