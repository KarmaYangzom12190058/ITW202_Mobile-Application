package com.gcit.project.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcit.project.ProverbAdapter;
import com.gcit.project.ProverbItem;
import com.gcit.project.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<ProverbItem> proverbItems = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ProverbAdapter(proverbItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        proverbItems.add(new ProverbItem("ཁ་གིས་མ་ནི་བགྱང་།  ལག་པ་སེམས་ཅན་གསད།", "0", "0"));
        proverbItems.add(new ProverbItem("ཡེ་ཤེས་པའི་མདའ།  རྐྱབ་སར་མི་མཐོང་།  ཕོག་སར་མཐོང་།", "1", "0"));
        proverbItems.add(new ProverbItem("གནམ་ལས་གནམ་ལྕགས་མ་བུདན།  ས་ལས་ས་ཆུ་མི་ཐོན།", "2", "0"));
        proverbItems.add(new ProverbItem("ཕྱི་ཡི་ལྕགས་རི།  ནང་གི་ནོར་བུ།", "3", "0"));
        proverbItems.add(new ProverbItem("མེ་ཕར་འཕུ།  རྒྱའོ་ཚུར་འཚིག།", "4", "0"));


        proverbItems.add(new ProverbItem("ཆརཔ་ཕར་རྐྱབ།  ཟིལཔ་ཚུར་ཁ་རེག། ཆརཔ་ཕར་ཁ་རྐྱབ་རུང་།  ཟིལཔ་ཚུར་ཁ་ཕོག་འོང་།", "5", "0"));
        proverbItems.add(new ProverbItem("ཤ་བླམ་ཚ།  བླམ་བ་རང་ཚ།", "6", "0"));
        proverbItems.add(new ProverbItem("བྱ་རོགས་ངན་པའི་གོངམ་ལས།  གོང་མ་བཟང་པོའི་བྱ་རོགས་སྐྱིད།", "7", "0"));
        proverbItems.add(new ProverbItem("མེ་ཏོག་ཆུང་རུང་མཆོད་པའི་རྗས།", "8", "0"));
        proverbItems.add(new ProverbItem("ཕམ་དང་བུ་བརྒྱུད་གཅིག་རུང་།  བསོད་ནམས་མི་གཅིག་སོ་སོ།", "9", "0"));


        proverbItems.add(new ProverbItem("ཕ་བཟང་ལུ་བུ་བཟང་།  མ་བཟང་ལུ་རྒྱུད་བཟང་།", "10", "0"));
        proverbItems.add(new ProverbItem("ཕྱག་འཚལ་བའི་མི་ལུ།  རྡོ་མ་རྐྱབ།", "11", "0"));
        proverbItems.add(new ProverbItem("བསམ་པ་བཟང་ན།  ས་དང་ལམ་ཡང་བཟང།", "12", "0"));
        proverbItems.add(new ProverbItem("ངན་པ་ཚར་མ་བཅད་ན།  བཟང་པོ་ཁྱུན་མི་ཐོན།", "13", "0"));
        proverbItems.add(new ProverbItem("ཤེས་པའི་མི་ལུ་སྟོན་མི་དགོ།  རྣོ་བའི་གྱི་ལུ་བརྡར་མི་དགོ།", "14", "0"));
        proverbItems.add(new ProverbItem("རང་ལེགས་པ་མི་ཆོག།  ཆ་རོགས་ལེགས་དགོ།", "15", "0"));


        proverbItems.add(new ProverbItem("ཁ་ལས་སླབ་ཚེ་ག་ཡང་མཁས། ལག་ལེན་འཐབ་ཚེ་ག་ཡང་དཀའ།", "16", "0"));
        proverbItems.add(new ProverbItem("མ་སླབ་ན་མི་གོ།  མ་རྐྱབ་ན་མི་ཕོག།", "17", "0"));
        proverbItems.add(new ProverbItem("སེམས་ཀྱིས་ལྷོད་ས། ལུས་ཀྱིས་མི་ལྷོད།", "18", "0"));
        proverbItems.add(new ProverbItem("རྣམ་རྟོག་མེད་པའི་རི་ལས།  དཔྱད་རེ་མེད་པའི་ཆརཔ།།", "19", "0"));
        proverbItems.add(new ProverbItem("ཁ་ནང་གི་རྨ་དེ།  ལྕེ་གིས་བཅོ་དགོ།", "20", "0"));


        proverbItems.add(new ProverbItem("མི་གིས་འབདཝ་མས་ཟེར་ཁྱི་གིས་འབད། ཁྱི་གི་མཇུག་མ་དར་འཕྱར།", "21", "0"));
        proverbItems.add(new ProverbItem("ཁ་གིས་ཤོབ་རྐྱབ་རུང་།  མིག་ཏོག་གིས་ཤོབ་མི་རྐྱབ།", "22", "0"));
        proverbItems.add(new ProverbItem("གཉིད་ཚད་རང་གིས་མ་བཟུང་ན།  གཏི་མུག་གཉིད་ལུ་རྫོགས་ནི་མེད།", "23", "0"));
        proverbItems.add(new ProverbItem("རང་ཐག་རང་གིས་བཅད་པ།  སུ་དང་གང་གིས་སླབ་མི་ཆོག།", "24", "0"));

        return root;
    }
}