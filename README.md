## Name: Mirza Radithya Ramadhana
## NPM: 2406405563
## Class: Pemrograman Lanjut A
## Deployment Link: https://thick-sandy-jaatzy-a8125cce.koyeb.app/

---

### Module 02 Reflection
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy
   on fixing them.
- Mengganti field injection dengan constructor injection
- Mengubah modifier pada class unit test menjadi default
- Menghapus import yang tidak digunakan
- Menghapus throws exception yang tidak mungkin terjadi
- Menghapus method yang tidak digunakan dan tidak ada implementasinya
- Mengsimplifikasi fungsi lambda agar hanya memanggil 1 fungsi lain

Strategi saya dalam memperbaiki setiap error adalah dengan melihat issue yang tampil pada code quality check (sonar cloud). Saya menggunakan saran dan cara perbaikan yang diberikan oleh Sonar Cloud.

2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current
   implementation has met the definition of Continuous Integration and Continuous
   Deployment? Explain the reasons (minimum 3 sentences)!

Menurut saya, implementasi saat ini sudah memenuhi definisi Continuous Integration dan Continuous Deployment. Berdasarkan Swaraj, CI adalah praktik dalam pengembangan perangkat lunak di mana perubahan dan pembaruan di kode terintegrasi dan terverifikasi oleh script otomatis. Workflow yang saya terapkan telah menjalankan build, test, dan integrasi dengan code quality tools secara otomatis saat PR atau push untuk melakukan CI.
Lalu, berdasarkan Swaraj juga, Continuous Deployment merupakan praktik dalam pengembangan perangkat lunak yang berperan untuk mendeploy kode kita secara otomatis ke server tertentu. Saya telah menggunakan Koyeb sebagai server dan Koyeb CLI yang saya taruh di workflow untuk melakukan tugas ini.

---

### Module 03 Reflection

1. Explain what principles you apply to your project!
   1) Single Responsibility Principle  
   Saya menerapkan prinsip ini dengan cara memindahkan kelas CarController dari dalam file ProductController.java ke file CarController.java.
   Hal tersebut saya lakukan agar setiap file punya satu responsibilitynya sendiri.
   Selain itu, saya juga memecah fungsi createCar yang sebelumnya memvalidasi dan menetapkan id sebuah objek mobil menjadi dua method terpisah. Satu method untuk memvalidasi dan menambah id car, satu lagi untuk menambahkan objek car ke data.
   2) Open Close Principle  
   Saya membuat CarRepository menjadi sebuah interface dan memindahkan implementasinya ke InMemoryCarRepository.
   Dengan demikian, repository baru, seperti DataBaseRepository, bisa ditambahkan tanpa merusak implementasi repositori lain yang sudah ada.
   3) Liskov  Substitution Principle  
   Saya menghapus hubungan antara class CarController dan ProductController dimana CarController sebelumnya merupakan subclass dari ProductController.
   Hal ini saya lakukan karena objek CarController tidak bisa menggantikan ProductController.
   Sebagai contoh, jenis modelnya yang berbeda.
   4) Interface Segregation Principle  
   Saya menerapkan prinsip ini pada saat saya membuat interface repository. Saya membuat interface tersebut dengan mempertimbangkan fungsi-fungsi yang dibutuhkan oleh class yang akan mengimplementasikannya.
   Fungsi-fungsi yang sekiranya tidak diperlukan tidak saya tambahkan.
   5) Dependency Inversion Principle  
   Saya membuat ProductRepository dan CarRepository menjadi sebuah interface. Dengan ini, class ProductService dan CarService tidak lagi bergantung langsung pada concrete class, melainkan pada interface.
2. Explain the advantages of applying SOLID principles to your project with examples.  
   Penerapan prinsip SOLID pada projek ini memberi pengaruh yang besar terhadap maintanability. Sebagai contoh, dengan menerapkan Open Closed Principle, saya bisa menambahkan repositori jenis baru tanpa mengubah repositori yang sudah ada. Selain itu, Single Responsibility Principle yang saya terapkan juga membantu maintanability kode. Kode menjadi lebih mudah ditest dan lebih jelas tugas untuk masing-masing class atau method.
   Prinsip-prinsip SOLID dapat meminimalkan resiko-resiko yang mungkin terjadi, seperti bug atau kode yang sulit dipahami. 
3. Explain the disadvantages of not applying SOLID principles to your project with examples.  
   Tanpa menerapkan prinsip SOLID, kode cenderung susah untuk dimaintain dan dipahami. Sebagai contoh, jika saya tidak menerapkan Open Close Principle, saya akan kesulitan untuk menambahkan implementasi baru tanpa menganggu implementasi yang sudah ada. Selain itu, saya juga menjadi susah untuk meng-test kode saya jika saya tidak menerapkan Single Responsibility Principle.