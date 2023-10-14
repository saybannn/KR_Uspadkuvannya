object Main {
  def main(args: Array[String]): Unit = {

    class Address(val street: String, val city: String, val zipCode: String) {
      override def toString: String = s"$street, $city, $zipCode"
    }


    class Human(val name: String, val age: Int, val address: Address) {
      override def toString: String = s"Name: $name, Age: $age, Address: $address"

      def greeting(): String = s"Hello, my name is $name, I am $age y.o.,and I live at ${address}."
    }


    class Student(name: String, age: Int, address: Address, val group: String) extends Human(name, age, address) {
      override def toString: String = s"Name: $name, Age: $age, Address: $address, Group: $group"

      def studentInfo(): String = s"Student Name: $name, Age: $age, Address: $address, Group: $group"
    }


    class Teacher(name: String, age: Int, address: Address, val listOfStudents: List[Student]) extends Human(name, age, address) {
      override def toString: String = {
        val studentNames = listOfStudents.map(_.name).mkString(", ")
        s"Name: $name, Age: $age, Address: $address, Students: $studentNames"
      }

      def teacherInfo(): String = {
        val studentInfoList = listOfStudents.map(_.studentInfo()).mkString("\n")
        s"Teacher Name: $name, Age: $age, Address: $address\nStudents:\n$studentInfoList"
      }
    }


    val student0 = new Student("Ivan", 18, new Address("Nekrasova", "Kherson", "12345"), "241")
    val student1 = new Student("Petro", 18, new Address("200-Rokiv", "Kherson", "67890"), "241")
    val student2 = new Student("Bohdan", 18, new Address("Pivnichna", "Kherson", "13579"), "241")

    val teacher = new Teacher("Maksym Yuriyovich Poltoratsky", 35, new Address("Pivdenna", "Kherson", "24680"), List(student0, student1, student2))
    println(teacher.teacherInfo())

    val studentNames = teacher.listOfStudents.map(_.name).mkString(", ")
    println(s"Student Names: $studentNames")
  }
}