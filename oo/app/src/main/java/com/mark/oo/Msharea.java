package com.mark.oo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Msharea extends Fragment implements CustomAdabter.OnItemListener{
View v;
RecyclerView recyclerView;
List<ModelClass> mList;
CustomAdabter customAdabter;

    public Msharea() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_msharea, container, false);
    recyclerView=v.findViewById(R.id.mshareaRecycler);
customAdabter=new CustomAdabter(mList,getContext());
recyclerView.setAdapter(customAdabter);
recyclerView.setLayoutManager(new LinearLayoutManager( getActivity()));
        String[] some_array = getResources().getStringArray(R.array.proj1);

    return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList=new ArrayList<>();
        mList.add(new ModelClass(R.drawable.lcd1_1,"مشروع الكتابة علي LCD","تتيح لك مكتبة LiquidCrystal التحكم في شاشات LCD المتوافقة مع برنامج التشغيل Hitachi HD44780. يوجد الكثير منهم ، ويمكنك عادةً التفرقة بينهم من خلال الواجهة التي يتواجد بها 16 دبوس. ويتيح لك هذا المشروع المعرفة اللازمة لارسال كلمة Hello World الى شاشة LCD.\n" +
                "\n" +
                "تتمتع شاشات LCD بواجهة متوازية ، مما يعني أن المتحكم يجب أن يتعامل مع عدة دبابيس واجهة في آن واحد للتحكم في الشاشة. تتكون الواجهة من المسامير التالية:\n" +
                "\n" +
                "دبوس تحديد السجل (RS) الذي يتحكم في ذاكرة شاشة LCD التي تكتب إليها البيانات. يمكنك تحديد إما سجل البيانات ، الذي يحتفظ بما يجري على الشاشة ، أو سجل التعليمات ، حيث يبحث جهاز التحكم في شاشة LCD عن إرشادات حول ما يجب القيام به بعد ذلك.\n" +
                "دبوس القراءة / الكتابة (R / W) الذي يحدد وضع القراءة أو وضع الكتابة\n" +
                "دبوس تمكين يتيح الكتابة إلى السجلات\n" +
                "8 دبابيس البيانات (D0 -D7). حالات هذه المسامير (عالية أو منخفضة) هي البتات التي تكتبها إلى أحد السجلات عند الكتابة ، أو القيم التي تقرأها عند القراءة.\n" +
                "هناك أيضًا دبوس تباين العرض (Vo) ودبابيس مزود الطاقة (+ 5V و Gnd) ودبابيس الإضاءة الخلفية LED (Bklt + و BKlt-) التي يمكنك استخدامها لتشغيل شاشة LCD والتحكم في تباين الشاشة وتشغيل وإيقاف تشغيل مؤشر LED الإضاءة الخلفية ، على التوالي.\n" +
                "\n" +
                "تتضمن عملية التحكم في الشاشة وضع البيانات التي تشكل صورة لما تريد عرضه في سجلات البيانات ، ثم وضع التعليمات في سجل التعليمات. تعمل مكتبة LiquidCrystal على تبسيط هذا الأمر بحيث لا تحتاج إلى معرفة الإرشادات ذات المستوى المنخفض.\n" +
                "\n" +
                "يمكن التحكم في شاشات LCD المتوافقة مع Hitachi في وضعين: 4 بت أو 8 بت. يتطلب وضع 4 بت سبعة دبابيس I / O من Arduino ، بينما يتطلب وضع 8 بت 11 دبابيس. لعرض النص على الشاشة ، يمكنك القيام بكل شيء في وضع 4 بت ، لذلك يوضح المثال كيفية التحكم في شاشة LCD مقاس 16 × 2 في وضع 4 بت.\n" +
                "\n" +
                "المكونات والادوات اللازمة\n" +
                "Arduino or Genuino Board\n" +
                "LCD Screen (compatible with Hitachi HD44780 driver)\n" +
                "pin headers to solder to the LCD display pins\n" +
                "10k ohm potentiometer\n" +
                "220 ohm resistor\n" +
                "hook-up wires\n" +
                "breadboard\n" +
                "الدوائر الكهربائية\n" +
                "قبل توصيل شاشة LCD بلوحة Arduino أو Genuino ، نقترح لصق شريط رأس الدبوس بموصل عدد 14 دبوسًا (أو 16) من شاشة LCD ، كما ترى في الصورة أعلاه.\n" +
                "\n" +
                "لتوصيل شاشة LCD بلوحة ، قم بتوصيل المسامير التالية:\n" +
                "\n" +
                "LCD RS دبوس إلى دبوس الرقمية 12\n" +
                "شاشات الكريستال السائل تمكين دبوس إلى رقم 11 الرقمية\n" +
                "LCD D4 دبوس إلى دبوس الرقمية 5\n" +
                "LCD D5 دبوس إلى دبوس الرقمية 4\n" +
                "LCD D6 دبوس إلى دبوس الرقمية 3\n" +
                "LCD D7 دبوس إلى دبوس الرقمية 2\n" +
                "بالإضافة إلى ذلك ، قم بتوصيل وعاء بحجم 10 كيلو إلى + 5 فولت و GND ، باستخدام ماسحة (الإخراج) لشاشات الكريستال السائل VO pin (pin3). يتم استخدام المقاوم 220 أوم لتشغيل الإضاءة الخلفية للعرض ، عادة على دبوس 15 و 16 من موصل LCD","// include the library code:\n" +
                "#include <LiquidCrystal.h>\n" +
                "\n" +
                "// initialize the library with the numbers of the interface pins\n" +
                "LiquidCrystal lcd(12, 11, 5, 4, 3, 2);\n" +
                "\n" +
                "void setup() {\n" +
                "  // set up the LCD's number of columns and rows:\n" +
                "  lcd.begin(16, 2);\n" +
                "  // Print a message to the LCD.\n" +
                "  lcd.print(\"MegaTronics\");\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  // set the cursor to column 0, line 1\n" +
                "  // (note: line 1 is the second row, since counting begins with 0):\n" +
                "  lcd.setCursor(0, 1);\n" +
                "  // print the number of seconds since reset:\n" +
                "  lcd.print(millis() / 1000);\n" +
                "}\n" +
                " ",R.drawable.lcd1_2,0,""));
        mList.add(new ModelClass(R.drawable.proj2_1,"مشروع بسيط لإنشاء إشارة مرور","\n" +
                "المكونات:\n" +
                "\n" +
                "3 ليد (احمر,اصفر,اخضر)\n" +
                "لوحة تجارب\n" +
                "3 مقاومات ( 220 اوم )\n" +
                "اسلاك للتوصيل\n","// التعريف بأرقام المدخلات\n" +
                "int red = 13;\n" +
                "int yellow = 12;\n" +
                "int green = 11;\n" +
                "\n" +
                "// دالة الاعداد , تعمل مرة واحدة عند التشغيل او اعاداة التشغيل\n" +
                "\n" +
                "void setup(){\n" +
                "pinMode(red,OUTPUT);\n" +
                "pinMode(yellow,OUTPUT);\n" +
                "pinMode(green,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "// دالة التكرار , تعمل مرارا وتكرارا الى ان توقف الجهاز\n" +
                "void loop(){\n" +
                "changeLights();\n" +
                "delay(15000);\n" +
                "}\n" +
                "\n" +
                "// يعمل الضوء الاخضر لمدة ثانيتين\n" +
                "void changeLights(){\n" +
                "  digitalWrite(green,HIGH);\n" +
                "delay(2000);\n" +
                "  // يتوقف الضوء الاخضر , ثم يعمل الاصفر لمدة 3 ثواني \n" +
                "digitalWrite(green,LOW);\n" +
                "digitalWrite(yellow,HIGH);\n" +
                "delay(3000);\n" +
                "\n" +
                "  // يتوقف الاصفر , ثم يعمل الاحمر لمدة 5 ثواني\n" +
                "digitalWrite(yellow,LOW);\n" +
                "digitalWrite(red,HIGH);\n" +
                "delay(5000);\n" +
                "\n" +
                " // يعمل الأحمر والاصفر معا لمدة ثانيتين\n" +
                "digitalWrite(yellow,HIGH);\n" +
                "delay(2000);\n" +
                "\n" +
                "  // يتوقف الاحمر والاصفر , ثم يعمل الأخضر\n" +
                "digitalWrite(yellow,LOW);\n" +
                "digitalWrite(red,LOW);\n" +
                "digitalWrite(green,HIGH);\n" +
                "}",R.drawable.proh2_2,0,""));
        mList.add(new ModelClass(R.drawable.proj3_1,"مشروع قياس درجة الحرارة ونسبة الرطوبة في الغرفة","المكونات : \n" +
                "لوحة اردوينو أونو\n" +
                "شاشة 16*2 \n" +
                "حساس الرطوبة والحرارة\n" +
                "مقاومة 1 كيلو اوم \n" +
                "لوحة اختبار\n" +
                "اسلاك التوصيل \n" +
                "و ثم قوم بالتوصيل كالشكل التالي\n" +
                "بعد فهمك للكود التالي، نفتح برنامج الأردوينو وتأكد من الاتصال بالانترنت لأنه يجب تحميل مكتبة الأكواد الخاصة بالحساس DHT library كالتالى: من شريط القوائم اختر المسار التالى: Sketch ثم Include library ثم Manage libraries\n" +
                "فى خانة البحث اكتب dht، سوف يظهر لك فى النتائج مكتبتين قم بالضغط عليهما ثم اختر Install كما هو موضح بالصورة التالية:\n" +
                "قم بإنشاء ملف مشروع جديد بالاسم الذي تريده واكتب الكود السابق فيه واحفظه عندك على جهازك، قم بتوصيل لوحة الأردوينو بالكمبيوتر لديك وارفع الكود إلى لوحة الأردوينو (upload).\n" +
                "ملحوظات هامة:\n" +
                "قد يظهر لك مشكلة أثناء عمل (compiling) من فضلك اقرأ جيداً وصف المشكلة في شريط المعلومات أسفل شاشة برنامج الأردوينو وحاول البحث عن المشكلة وحلها.\n" +
                "قد تصادفك مشكلة تتعلق بعدم قدرة الأردوينو على العثور على أكواد تتعلق بـ (Adafruit_sensor)، إذن سوف ندخل مرة أخرى إلى Sketch ثم Include library ثم Manage libraries ، ثم ابحث عن (Adafruit_sensor.h) وقم بتحميل المكتبة الخاصة بها كما بالشكل التالى وستحل المشكلة.\n","#include   // تضمين مكتبة الأكواد الخاصة بالشاشة\n" +
                "#include \"DHT.h\"              // تضمين مكتبة الحساس\n" +
                "#define DHTTYPE DHT11        //تعرف نوع الحساس\n" +
                "#define DHTPIN 12                                 //تعريف رقم طرف توصيل الحساس\n" +
                "LiquidCrystal lcd(2, 3, 4, 5, 6, 7);              //LCD connection pins\n" +
                "DHT dht(DHTPIN, DHTTYPE);\n" +
                "void setup()                   //دالة الإعداد وتنفذ مرة واحدة فقط فى بداية البرنامج\n" +
                "{                                     //كل الأوامر التالية بين القوسين ضمن هذه الدالة\n" +
                "  lcd.begin(16, 2);                              //أمر لبدء تشغيل الشاشة\n" +
                "  dht.begin();                                   //أمر لبدء تشغيل الحساس\n" +
                "  lcd.clear();            //أمر مسح الشاشة\n" +
                "  lcd.print(\"Temp & Humidity\");                  //أمر طباعة رسالة تعريفية للدائرة\n" +
                "  lcd.setCursor(0, 1);\n" +
                "  lcd.print(\"  Measurement \");\n" +
                "  delay(2000);             //أمر إنتظار ثانيتين\n" +
                "  lcd.clear();\n" +
                "  lcd.print(\"  ARABS MAKERS  \");\n" +
                "  delay(2000);\n" +
                "  lcd.clear();\n" +
                "  lcd.print(\"Temp:  Humidity:\");\n" +
                "}\n" +
                "void loop()                        //دالة التكرار وتنفذ باستمرار طالما يوجد تغذية كهرباء للأردوينو\n" +
                "{\n" +
                "  delay(500);\n" +
                "  lcd.setCursor(0, 1);                          //وضع المؤشر فى اول عمود والصف الثانى\n" +
                "  float h = dht.readHumidity();                 // قراءة نسبة الرطوبة\n" +
                "  float f = dht.readTemperature(true);          //قراءة قيمة درجة الحرارة بالفهرنهايت من الحساس\n" +
                "  float  c = (f - 32) / 1.8;                               //تحويل من فهرنهايت إلى سيليزيوس\n" +
                "  if (isnan(h) || isnan(f))\n" +
                "  {\n" +
                "    lcd.print(\"ERROR\");\n" +
                "    return;\n" +
                "  }\n" +
                "  lcd.print(c);                                // طباعة درجة الحرارة\n" +
                "  lcd.setCursor(7, 1);\n" +
                "  lcd.print(h);                                // طباعة الرطوبة\n" +
                "}",R.drawable.proj3,0,""));
        mList.add(new ModelClass(R.drawable.flame1_min,"مشروع أستشعار اللهب","حساس استشعار اللهب يمكن استخدامه للكشف عن مصدر النار أو مصادر الضوء\n" +
                "\n" +
                "\n" +
                "من الطول الموجي في نطاق 760 – 1100 نانومتر. ويستعمل هذه المجس حساس من نوع  YG1006 وهو عباره عن الحساسية ترانزستور ضوئي والذي يحتوي على سرعة عالية . ,ومن خلال الايبوكسي الأسود، يستطيع هذه الحساس استشعار الأشعة تحت الحمراء الصادرة عن اللهب. وتستطيع استعمال هذه المجس في الروبوتات للكشف عن النار حيث يعمل كعيون لها, يستطيع هذه المجس كشف النار في نطاق  60 درجة مئوية، مع زيادة المسافة، يتم تقليل نطاق تدريجيا. حساس اللهب يتفاعل بشكل عادي مع الضوء في النطاق الموجي، لكنه حساس جدا للهب.\n" +
                "\n" +
                "\n" +
                "ملاحظة: يجب ان يكون هناك مسافة كافية بين حساس اللهب وشعلة اللهب حتى لا يتضرر حساس اللهب\n" +
                "\n" +
                "المميزات:\n" +
                "- القدرة على إخراج الإشارات الرقمية (العالية والمنخفضة).\n" +
                "- القدرة على الانتاج إشارة تناظرية (إشارة الجهد)،ويمكن قياسها بدقة أكثر، ومناسبة في حالة الحاجة لدقة عالية.\n" +
                "الطاقة: 3.3 – 5 فولت\n" +
                "- بعد الكشف: 20 سم (4.8 فولت) – 100 سم (1 فولت).\n" +
                "- زاوية الكشف تساوي تقريبا 60 درجة.","int buzzer = 8;\n" +
                "int LED = 7;\n" +
                "int flame_sensor = 4;\n" +
                "int flame_detected;\n" +
                "\n" +
                "void setup()\n" +
                "{\n" +
                "  Serial.begin(9600);\n" +
                "  pinMode(buzzer, OUTPUT);\n" +
                "  pinMode(LED, OUTPUT);\n" +
                "  pinMode(flame_sensor, INPUT);\n" +
                "}\n" +
                "\n" +
                "void loop()\n" +
                "{\n" +
                "  flame_detected = digitalRead(flame_sensor);\n" +
                "  if (flame_detected == 1)\n" +
                "  {\n" +
                "    Serial.println(\"Flame detected...! take action immediately.\");\n" +
                "    digitalWrite(buzzer, HIGH);\n" +
                "    digitalWrite(LED, HIGH);\n" +
                "    delay(200);\n" +
                "    digitalWrite(LED, LOW);\n" +
                "    delay(200);\n" +
                "  }\n" +
                "  else\n" +
                "  {\n" +
                "    Serial.println(\"No flame detected. stay cool\");\n" +
                "    digitalWrite(buzzer, LOW);\n" +
                "    digitalWrite(LED, LOW);\n" +
                "  }\n" +
                "  delay(1000);\n" +
                "}",R.drawable.flame2_min,0,""));
        mList.add(new ModelClass(R.drawable.water1,"قياس مستوى المياه في الخزان","ن خلال هذه التجربة سوف نتعرف على طريقة تصميم جهاز إلكتروني لقياس مستوى المياه في الخزان باستخدام متحكم دقيق من نوع أردوينو Arduino لقراءة مستوى المياه عبر حساس يعمل بالموجات فوق الصوتية.\n" +
                "\n" +
                "متطلبات المشروع\n" +
                "1- متحكم دقيق من نوع  أردوينو نانو Arduino Nano\n" +
                "2- حساس موجات فوق صوتية HC-SR04 Ultrasonic Sensor\n" +
                "3-  لوح تجارب Breadboard\n" +
                "4- مصابيح إل إي دي بثلاثة ألوان أحمر و أصفر وأخضر\n" +
                "5- مجموعة أسلاك توصيل\n" +
                "\n" +
                "خطوات العمل\n" +
                "تركيب جميع القطع السابقة حسب المخطط والخطوات التالية:\n" +
                "\n" +
                "تركيب المتحكم الدقيق على لوح التجارب بشكل طولي في الجهة اليسار على خط C و G\n" +
                "تركيب حساس الموجات فوق الصوتية على المسار J\n" +
                "تركيب مصابيح إل إي دي على المسار J مقابل بحيث تصبح جميع أرجل المصباح الموجبة (الرجل الطويلة للمصباح موجبة) لأرجل المتحكم الدقيق D10 و D9 و D8 وتوصيل الأرجل السالبة على المسار السالب في لوح التجارب\n" +
                "توصيل رجل المتحكم الدقيق GND في نفس المسار السالب السابق في لوح التجارب\n" +
                "توصيل رجل المتحكم الدقيق 5V في رجل حساس الموجات الصوتية VCC\n" +
                "توصيل رجل المتحكم الدقيق GND في رجل حساس الموجات الصوتية GND\n" +
                "توصيل رجل المتحكم الدقيق D4 في رجل حساس الموجات الصوتية Trig\n" +
                "توصيل رجل المتحكم الدقيق D3 في رجل حساس الموجات الصوتية Echo","\n" +
                "/*\n" +
                " * Water level project 1.0\n" +
                " * Arduino day 2017\n" +
                " * Parmg.org Group\n" +
                " * https://github.com/parmg/arduino-day/blob/master/water_level.ino\n" +
                " * \n" +
                " * Requirements\n" +
                " * 1. Breadboard\n" +
                " * 2. Arduino Nano v3\n" +
                " * 3. HC-SR04 Ultrasonic Sensor\n" +
                " * 4. LEDs \n" +
                " * 5. Cables\n" +
                " * \n" +
                " * Instructions\n" +
                " * 1. Install Arduino on the Breadboard\n" +
                " * 2. Connect Arduino 5V to Ultrasonic Sensor VCC\n" +
                " * 3. Connect Arduino GND to Ultrasonic Sensor GND\n" +
                " * 4. Connect Arduino D3 to Ultrasonic Sensor ECHO\n" +
                " * 5. Connect Arduino D4 to Ultrasonic Sensor TRIG\n" +
                " * 6. Connect Arduino GND to Breadboard Minus line\n" +
                " * 7. Connect Arduino D10 to long leg in LED (high level)\n" +
                " * 8. Connect Arduino D9 to long leg in LED (medium level) \n" +
                " * 9. Connect Arduino D8 to long leg in LED (low level led) \n" +
                " * 10. Connect All LEDs short leg to  Breadboard Minus line\n" +
                " * \n" +
                " */\n" +
                "\n" +
                "#define echoPin 3 // Echo Pin\n" +
                "#define trigPin 4 // Trigger Pin\n" +
                "\n" +
                "#define LowPin 10 // low level LED\n" +
                "#define MidPin 9  // medium level LED\n" +
                "#define HigPin 8  // high level LED\n" +
                "\n" +
                "#define LowRange 10 // Low Range\n" +
                "#define MidRange 20 // Mid Range\n" +
                "#define HigRange 30 // Hi Range\n" +
                "\n" +
                "long duration, distance; // Duration used to calculate distance\n" +
                "\n" +
                "void setup() {\n" +
                "  // send logs\n" +
                "  Serial.begin (9600);\n" +
                "  // to send soundwaves\n" +
                "  pinMode(trigPin, OUTPUT);\n" +
                "  // to receive soundwaves\n" +
                "  pinMode(echoPin, INPUT);\n" +
                "  // LEDs pins\n" +
                "  pinMode(LowPin, OUTPUT);\n" +
                "  pinMode(MidPin, OUTPUT);\n" +
                "  pinMode(HigPin, OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  /* The following trigPin/echoPin cycle is used to determine the\n" +
                "  distance of the nearest object by bouncing soundwaves off of it. */ \n" +
                "\n" +
                "  // stop pin\n" +
                "  digitalWrite(trigPin, LOW);\n" +
                "  // wait for 2ms\n" +
                "  delayMicroseconds(2);\n" +
                "  \n" +
                "  // send soundwaves\n" +
                "  digitalWrite(trigPin, HIGH);\n" +
                "  // wait for 10ms\n" +
                "  delayMicroseconds(10);\n" +
                "  // stop pin\n" +
                "  digitalWrite(trigPin, LOW);\n" +
                "  // read the soundwaves\n" +
                "  duration = pulseIn(echoPin, HIGH);\n" +
                "  // Calculate the distance (in cm) based on the speed of sound.\n" +
                "  distance = duration/58.2;\n" +
                " \n" +
                "  if (distance > 0 and distance <= LowRange){\n" +
                "    digitalWrite(HigPin, LOW);\n" +
                "    digitalWrite(MidPin, LOW);\n" +
                "    digitalWrite(LowPin, HIGH); // On\n" +
                "    Serial.println(\"LowPin\");\n" +
                "  } else if (distance > LowRange and distance <= MidRange){\n" +
                "    digitalWrite(HigPin, LOW);\n" +
                "    digitalWrite(MidPin, HIGH); // On\n" +
                "    digitalWrite(LowPin, LOW);\n" +
                "    Serial.println(\"MidPin\");\n" +
                "  } else {\n" +
                "    digitalWrite(HigPin, HIGH); // On\n" +
                "    digitalWrite(MidPin, LOW);\n" +
                "    digitalWrite(LowPin, LOW);\n" +
                "    Serial.println(\"HigPin\");\n" +
                "  }\n" +
                "  \n" +
                "  // Send the distance to the computer using Serial protocol\n" +
                "  Serial.println(distance);\n" +
                "\n" +
                "  // Delay 300ms before next reading.\n" +
                "  delay(300);\n" +
                "}",R.drawable.water1,0," "));
        mList.add(new ModelClass(R.drawable.sec11,"قفل ذكي باستخدام قارئ البطاقات MFRC522 RFID مع الاردوينو","ماهي RFID :\n" +
                "RFID هي التعرف علي الهوية باستخدام موجات الراديو  وهي تستخدم على نطاق واسع في العديد من الصناعات لمهام مثل تعقب الأفراد والتحكم في الوصول وإدارة سلسلة التوريد وتتبع الكتب في المكتبات وأنظمة الرسوم وما إلى ذلك .\n" +
                "\n" +
                "فكرة المشروع :\n" +
                "يتم استخدام بطاقات تعريف الهوية من أجل فتح أو أغلاق القفل , حيث يتم أستخدام 2 ليد واحد للدلالة علي حالة اسجابة القفل للبطاقة المسموح لها والاخر لعدم مطابقة البطاقة وتشغيل الانذار في الحال .\n" +
                "Arduino UNO board   —-> Atmega328P datasheet\n" +
                "MFRC522 RFID reader\n" +
                "Red and Green LEDs\n" +
                "Breadboard\n" +
                "Jumper wires\n","#include \"SPI.h\"\n" +
                "#include \"MFRC522.h\"\n" +
                "#define SS_PIN 10\n" +
                "#define RST_PIN 9\n" +
                "#define LED_PIN1 6\n" +
                "#define LED_PIN2 7\n" +
                "MFRC522 rfid(SS_PIN, RST_PIN);\n" +
                "MFRC522::MIFARE_Key key;\n" +
                "void setup() {\n" +
                "  // put your setup code here, to run once:\n" +
                "  Serial.begin(9600);\n" +
                "  SPI.begin();\n" +
                "  rfid.PCD_Init();\n" +
                "  pinMode(LED_PIN1, OUTPUT);\n" +
                "  pinMode(LED_PIN2, OUTPUT);\n" +
                "  Serial.println(\"I am waiting for card...\");\n" +
                "}\n" +
                "void loop() {\n" +
                "  // put your main code here, to run repeatedly:\n" +
                "  if (!rfid.PICC_IsNewCardPresent() || !rfid.PICC_ReadCardSerial())\n" +
                "    return;\n" +
                "  // Serial.print(F(\"PICC type: \"));\n" +
                "  MFRC522::PICC_Type piccType = rfid.PICC_GetType(rfid.uid.sak);\n" +
                "  // Serial.println(rfid.PICC_GetTypeName(piccType));\n" +
                "  // Check is the PICC of Classic MIFARE type\n" +
                "  if (piccType != MFRC522::PICC_TYPE_MIFARE_MINI &&\n" +
                "      piccType != MFRC522::PICC_TYPE_MIFARE_1K &&\n" +
                "      piccType != MFRC522::PICC_TYPE_MIFARE_4K) {\n" +
                "    Serial.println(F(\"Your tag is not of type MIFARE Classic.\"));\n" +
                "    return;\n" +
                "  }\n" +
                "  String strID = \"\";\n" +
                "  for (byte i = 0; i < 4; i++) {\n" +
                "    strID +=\n" +
                "      (rfid.uid.uidByte[i] < 0x10 ? \"0\" : \"\") +\n" +
                "      String(rfid.uid.uidByte[i], HEX) +\n" +
                "      (i != 3 ? \":\" : \"\");\n" +
                "  }\n" +
                "  strID.toUpperCase();\n" +
                "  Serial.print(\"Tap card key: \");\n" +
                "  Serial.println(strID);\n" +
                "  delay(1000);\n" +
                "  if (strID.indexOf(\"20:CC:6F:85\") >= 0) {  //put your own tap card key;\n" +
                "    Serial.println(\"********************\");\n" +
                "    Serial.println(\"**Authorised acces**\");\n" +
                "    Serial.println(\"********************\");\n" +
                "    digitalWrite(LED_PIN1, HIGH);\n" +
                "    delay (5000);\n" +
                "    digitalWrite(LED_PIN1, LOW);\n" +
                "    return;\n" +
                "  }\n" +
                "  else {\n" +
                "    Serial.println(\"****************\");\n" +
                "    Serial.println(\"**Acces denied**\");\n" +
                "    Serial.println(\"****************\");\n" +
                "    digitalWrite(LED_PIN2, HIGH);\n" +
                "    delay (5000);\n" +
                "    digitalWrite(LED_PIN2, LOW);\n" +
                "    return;\n" +
                "  }\n" +
                "}",R.drawable.sec22,0,""));

    }

    @Override
    public void onItemClick(int position) {
       mList.get(position);
        Intent intent=new Intent(Msharea.this.getActivity(),ItemActivity.class);
        startActivity(intent);
    }
}
