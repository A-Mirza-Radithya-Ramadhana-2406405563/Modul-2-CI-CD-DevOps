## Name: Mirza Radithya Ramadhana
## NPM: 2406405563
## Class: Pemrograman Lanjut A

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