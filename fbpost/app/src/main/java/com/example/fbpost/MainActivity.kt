package com.example.fbpost
import ImageAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class FbPost(
    val id: String,
    val content: String,
    val timestamp: String,
    val Image: String,
    val Link: String
)

@Serializable
data class UpdateData(
    val updateTime: String,
    val FbPosts: List<FbPost>
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jsonString = """
            {
                "updateTime": "1719201557586",
                "FbPosts": [
                    {
                        "content": "Recognize the endless blessings of Allah (SWT) in your life, and fully embrace them to achieve true success. Android: https://play.google.com/store/apps/details... #Quran #QuranApp #Quranhour #QuranMajeed #Islam #LearnQuran #QuraniOS #QuranAndroid null null null null null null null null null null Android: https://play.google.com/store/apps/details... iPhone/iPad: https://apps.apple.com/.../quran-majeed.../id365557665",
                        "Link": "https://www.facebook.com/photo/?fbid=822808793288729&set=a.521636483405963&__cft__[0]=AZVYk5yFe_gP9PZewPAHeViv5SjGbaf-kcDMMGOrouuqN2flPmoXNSVK9t5THhHbWGXDndJOLag08ZKrUWfonYZ1XxOkOUlKfsJD8gNDWepdQwK539moK_Jxr_3gcapp4yAZ9A1Up89zPNbHpV4hbS0c51ImXuaZ6lR6BpodmrsYV3ocr7Q6QksWmJklSLJNv2smCtYuqAo_hk-hfNB8IQli&__tn__=EH-R",
                        "timestamp": "1719201462223",
                        "Image": "https://scontent.fkhi17-1.fna.fbcdn.net/v/t39.30808-6/417502282_822808789955396_5086680797617523058_n.jpg?stp=dst-jpg_s1080x2048&_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_ohc=cKXn7OquyCIQ7kNvgEiAN7p&_nc_ht=scontent.fkhi17-1.fna&oh=00_AYBTarfDnj2WK9-WQdD-mKtv6sc7Ze6YOE5wLIAAC7NUfQ&oe=667EC58B",
                        "id": "822808793288729"
                    },
                     {
            "content": "Once you have completed your Hajj duties, continue to remember Allah (SWT) with devotion as strong as speaking of your ancestors, or even more fervently. Android: https://play.google.com/store/apps/details... #Quran #QuranApp #Quranhour #QuranMajeed #Islam #LearnQuran #QuraniOS #QuranAndroid null null null null null null null null null null Android: https://play.google.com/store/apps/details... iPhone/iPad: https://apps.apple.com/.../quran-majeed.../id365557665",
            "Link": "https://www.facebook.com/photo/?fbid=816075977295344&set=a.521636483405963&__cft__[0]=AZWEnN70cz0k9PpH_mCXa0rtgfbmp7rT7qzwfEv1m1bAMbadZvEgZ8KhcXZhW5juCKyP60Ea-OTJpyF8KrANxeGq3nMfF9SiC_dC-jOk7In88HWqW0eq2E-z0kxwM-ZZ942X6zBrSS7AGQ16tmpscj2E03MnDbtLyS9pj20Exoh-izuttZYjcdJ9n0_GND_wH5EpnJaxn40GcJqPdzmkscd-&__tn__=EH-R",
            "timestamp": "1719201426223",
            "Image": "https://scontent.fkhi17-1.fna.fbcdn.net/v/t39.30808-6/447895829_816075973962011_3998855458866419398_n.jpg?stp=dst-jpg_s1080x2048&_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=qwTl6wwwMnMQ7kNvgGUYz5h&_nc_ht=scontent.fkhi17-1.fna&oh=00_AYDPDEVK9f5yphlSX_9g97AXaCWM0K8k_cl2-z2fjx3CKg&oe=667EC519",
            "id": "816075977295344"
        },
        {
            "content": "The ultimate prize of a Hajj accepted by Allah (SWT) is none other than Heaven itself. Embrace this journey of faith with devotion, aiming for the eternal bliss of Heaven as your ultimate reward. Android: https://play.google.com/store/apps/details... #Quran #QuranApp #Quranhour #QuranMajeed #Islam #LearnQuran #QuraniOS #QuranAndroid null null null null null null null null null null Android: https://play.google.com/store/apps/details... iPhone/iPad: https://apps.apple.com/.../quran-majeed.../id365557665",
            "Link": "https://www.facebook.com/photo/?fbid=816061763963432&set=a.521636483405963&__cft__[0]=AZUzN_xNcwLaFyOWE8pO_XA7SIDtCxSN3cMwEf7ZIOk5332LymPRFBkTqJ5KF9g5_wnRwbNqobDzlyyxI1SwlkuJzPGXnkKjBl-bNlu9Iv6P0wXm3DL-XfHOqvhwRMRezm4FZvfDMTBUQKRmE9KfJK63PpdW9MzLIfzguHRE7QFi45W17uHse1MQvybAy0NZbLX0US5dOR0xuOcaAQZz3F74&__tn__=EH-R",
            "timestamp": "1719201410223",
            "Image": "https://scontent.fkhi17-1.fna.fbcdn.net/v/t39.30808-6/448021973_816061760630099_1521746481338039214_n.jpg?stp=dst-jpg_s1080x2048&_nc_cat=106&ccb=1-7&_nc_sid=5f2048&_nc_ohc=bXPp3bGcZEYQ7kNvgFyNa7G&_nc_ht=scontent.fkhi17-1.fna&oh=00_AYClpK2ze-8VDjqlZ0BgdZ-SjLwsdTgZ0pXsdLVs_Xi_ig&oe=667EBFD2",
            "id": "816061763963432"
        },
        {
            "content": "As the blessed day of Eid-Al-Adha approaches, let us celebrate with a spirit of sacrifice and gratitude.  Quran Majeed App sends warm wishes to you & your loved ones for a joyous Eid!  May Allah (SWT) accept our sacrifices and shower blessings upon our good deeds. #QuranApp #Quranhour #QuranMajeed #Islam #LearnQuran #QuraniOS #QuranAndroid #EidulAdha24 null null null null null null null null null Quran Majeed App sends warm wishes to you & your loved ones for a joyous Eid!  null",
            "Link": "https://www.facebook.com/photo/?fbid=816071107295831&set=a.521636483405963&__cft__[0]=AZUU0BrlOF_O_uOqZj_79CumemcU52l8EtLb1HELy3feHVlsqTPhM9CxSmbRpppZ3EwweO4JOwRP6TyblyfpjcFNA1CNFPkDw19khDksOkDUseKS-EtfuqgOhdj3zyD80oQmru1xFqwNVaTPp-J04xg2c1TGeCRbxfXm4eogVwlNDCBhvZxz20_MenA7R5j3UU1yjvtaLPEhexGIZxC13U7G&__tn__=EH-R",
            "timestamp": "1719201394223",
            "Image": "https://scontent.fkhi17-1.fna.fbcdn.net/v/t39.30808-6/448087907_816071103962498_1350160957152219180_n.jpg?stp=dst-jpg_s1080x2048&_nc_cat=101&ccb=1-7&_nc_sid=5f2048&_nc_ohc=7n6AGRHqjDEQ7kNvgEOUVBJ&_nc_ht=scontent.fkhi17-1.fna&oh=00_AYBUMCvOypw1kbhqA56r1vAX8u-dQOwYNAY77eOFNSuvTQ&oe=667ECA99",
            "id": "816071107295831"
        }
                ]
            }"""

        val json = Json { ignoreUnknownKeys = true }


        val updateData = json.decodeFromString<UpdateData>(jsonString)


        val recyclerView: RecyclerView = findViewById(R.id.RecyclerView)



        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ImageAdapter(this, updateData.FbPosts.map { it.Image }, updateData.FbPosts)
    }
}
