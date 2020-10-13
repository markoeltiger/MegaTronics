package com.mark.oo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */

public class ContactUs extends Fragment {
    View v;
List<String> adviselist;

    public ContactUs() {
        // Required empty public constructor
    }
Button advise;
    Context context;
    int  adviseindex;
    Button face;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    v = inflater.inflate(R.layout.fragment_contact_us, container, false);

    adviselist=new ArrayList<String>();
    adviselist.add("لا تترك المشكلات تتراكم عليك");
        adviselist.add("قم بتحويل المشاكل إلي اجزاء أصغر لتتمكن من حلها ");
        adviselist.add("عندما تقابلك مشكلة اولاً تعرف ما سببها الكود البرمجي ام التوصيلات");
        adviselist.add("دائماً لن تجد المعلومة كاملة وسهلة، أحياناً ستجد نقص في المعلومة أو قد تواجه خطأ لديك لم يواجهه الآخرون قد يكون أنت أول شخص يصادفه هذا النوع من الأخطاء، لذا عليك المحاولة والتجربة ومع كثرة التجارب ستكتسب الخبرة، والبحث على الإنترنت قد يساعدك أو يعطيك الخيط الذي تبدأ به أو يعطيك مثالاً لمشكلتك، لذا تعلم الطريقة في التعامل مع المشاكل ولا تحفظ طرق الحل وأتمنى لك التوفيق.\n");
     context= v.getContext();
        advise =v.findViewById(R.id.advisebutton);
        face =v.findViewById(R.id.gofacebook);
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/megaaatronics"));

                startActivity(intent);
            }
        });
        ImageView imageView = v.findViewById(R.id.ca);

        Glide.with(this).load(R.drawable.intro).into(imageView);
advise.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle("MegaTronics");
        Random r =new Random();
        int advisenumber =r.nextInt(adviselist.size()-2)+2;
        for (int i=0 ;i<advisenumber;i++ ){
            Random Rindex=new Random();
              adviseindex =Rindex.nextInt(adviselist.size()-0)+0;


        }
        builder.setMessage(adviselist.get(adviseindex));
        builder.setPositiveButton("tes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"حسناً",Toast.LENGTH_SHORT);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
});

return v;
    }
}
