//package com.kevinmaher.x14328981.happy;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.Fragment;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.CollectionReference;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.Query;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import org.w3c.dom.Document;
//
//import java.util.ArrayList;
//
//import com.kevinmaher.x14328981.happy.models.Mood;
//
//public class HomeFragment extends Fragment implements
//        View.OnClickListener,
//        IMainActivity,
//        SwipeRefreshLayout.OnRefreshListener{
//
//    public static HomeFragment newInstance() {
//        HomeFragment fragment = new HomeFragment();
//        return fragment;
//    }
//
//    private static final String TAG = "HomeFragment";
//
//    //Firebase
//    private FirebaseAuth.AuthStateListener mAuthListener; //TODO get this from main activity
//
//    //widgets
//    private FloatingActionButton mFab;
//    private RecyclerView mRecyclerView;
//    private SwipeRefreshLayout mSwipeRefreshLayout;
//
//    //variables
//    //    private Button btnLogUpdate;
//    private View mParentLayout;
//    private ArrayList<Mood> mMoods = new ArrayList<>();
//    private MoodRecyclerViewAdapter mMoodRecyclerViewAdapter;
//    private DocumentSnapshot mLastQueriedDocument;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_home,container,false);
//
//        mFab = view.findViewById(R.id.fab);
//        mParentLayout = view.findViewById(android.R.id.content);
//        mRecyclerView = view.findViewById(R.id.recycler_view);
//        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
//
//        mFab.setOnClickListener(this);
//        mSwipeRefreshLayout.setOnRefreshListener(this);
//
////        setupFirebaseAuth(); //TODO TOGGLE COMMENT
////        initRecyclerView();
////        getMoods(); //TODO TOGGLE COMMENT //CAUSES ISSUE
//
////        TODO UNCOMMENT BELOW
////        btnLogUpdate = (Button) view.findViewById(R.id.btn_log_update);
//
////        btnLogUpdate.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//////                Toast.makeText(getActivity(), "Testing button 1", Toast.LENGTH_SHORT).show();
////
////                Intent intent = new Intent(getActivity(), UpdateActivity.class);
////                startActivity(intent);
////            }
////        });
//
//        return view;
//    }
//
//
//    @Override
//    public void deleteMood(final Mood mood) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        DocumentReference moodRef = db
//                .collection("moods")
//                .document(mood.getMood_id());
//
//        moodRef.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    makeSnackBarMessage("Mood deleted");
//                    mMoodRecyclerViewAdapter.removeMood(mood);
//                }
//                else{
//                    makeSnackBarMessage("Error: Unable to delete mood");
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onRefresh() {
////        getMoods(); //TODO TOGGLE COMMENT
//        mSwipeRefreshLayout.setRefreshing(false);
//    }
////
//    private void getMoods(){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        CollectionReference moodsCollectionRef = db
//                .collection("moods");
//
//        Query moodsQuery = null;
//        if(mLastQueriedDocument != null){
//            moodsQuery = moodsCollectionRef
//                    .whereEqualTo("user_id", FirebaseAuth.getInstance().getCurrentUser().getUid())
//                    .orderBy("timestamp",Query.Direction.ASCENDING)
//                    .startAfter(mLastQueriedDocument);
//        }
//        else{
//            moodsQuery = moodsCollectionRef
//                    .whereEqualTo("user_id", FirebaseAuth.getInstance().getCurrentUser().getUid())
//                    .orderBy("timestamp", Query.Direction.ASCENDING);
//        }
//
//        moodsQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful()){
//                    for(QueryDocumentSnapshot document: task.getResult()){
//                        Mood mood = document.toObject(Mood.class);
//                        mMoods.add(mood);
////                        Log.d(TAG, "onComplete: got a new mood. Position: " + (mMoods.size() - 1));
//                    }
//                    if(task.getResult().size() !=0){
//                        mLastQueriedDocument = task.getResult().getDocuments()
//                                .get(task.getResult().size() -1);
//                    }
//                    mMoodRecyclerViewAdapter.notifyDataSetChanged();
//                }
//                else{
//                    makeSnackBarMessage("Failed to get moods.");
//                }
//            }
//        });
//    }
//
//    private void initRecyclerView(){
//        if(mMoodRecyclerViewAdapter == null){
//            mMoodRecyclerViewAdapter = new MoodRecyclerViewAdapter(this.getActivity(), mMoods);
//        }
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
//        mRecyclerView.setAdapter(mMoodRecyclerViewAdapter);
//    }
//
//    @Override
//    public void updateMood(final Mood mood) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        DocumentReference moodRef = db
//                .collection("moods")
//                .document(mood.getMood_id());
//
//        moodRef.update(
//                "title", mood.getTitle(),
//                "content", mood.getContent()
//        ).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    makeSnackBarMessage("Mood updated");
//                    mMoodRecyclerViewAdapter.updateMood(mood);
//                }
//                else{
//                    makeSnackBarMessage("Unable to update mood");
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onMoodSelected(Mood mood) {
//        ViewMoodDialog dialog =ViewMoodDialog.newInstance(mood);
//        dialog.show(getFragmentManager(), getString(R.string.dialog_view_mood));
//    }
//
//    @Override
//    public void createNewMood(String title, String content) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        DocumentReference newMoodRef = db
//                .collection("moods")
//                .document();
//
//        Mood mood = new Mood();
//        mood.setTitle(title);
//        mood.setContent(content);
//        mood.setMood_id(newMoodRef.getId());
//        mood.setUser_id(userId);
//
//        newMoodRef.set(mood).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    makeSnackBarMessage("Updated mood");
////                    getMoods();
//                }
//                else{
//                    makeSnackBarMessage("Error: Unable to update mood");
//                }
//            }
//        });
//    }
//
//    private void makeSnackBarMessage(String message){
//        Snackbar.make(mParentLayout, message, Snackbar.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch(view.getId()){
//            case R.id.fab:{
//                //create new mood
//                NewMoodDialog dialog = new NewMoodDialog();
//                dialog.show(getFragmentManager(), getString(R.string.dialog_new_mood));
//                break;
//            }
//        }
//    }
//
////menu button
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.more, menu);
////        return true;
////    }
////
////    //menu contents
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        switch (item.getItemId()) {
////            case R.id.menu_more_filter:
////                startActivity(new Intent(this, SettingsActivity.class));
////                return true;
////            case R.id.menu_more_feedback:
////                Intent Email = new Intent(Intent.ACTION_SEND);
////                Email.setType("text/email");
////                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "kevm66@gmail.com" });
////                Email.putExtra(Intent.EXTRA_SUBJECT, "Happy - Feedback");
//////                Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
////                startActivity(Intent.createChooser(Email, "Send Feedback:"));
////                return true;
////            case R.id.menu_more_settings:
////                startActivity(new Intent(this, SettingsActivity.class));
////                return true;
////            case R.id.menu_more_about:
////                startActivity(new Intent(this, SupportFragment.class));
////                return true;
////            case R.id.menu_more_log_out:
////                AuthUI.getInstance().signOut(this);
////                return true;
////            default:
////                return super.onOptionsItemSelected(item);
////        }
////    }
//}
//package com.kevinmaher.x14328981.happy;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.Fragment;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.CollectionReference;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.Query;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import org.w3c.dom.Document;
//
//import java.util.ArrayList;
//
//import com.kevinmaher.x14328981.happy.models.Mood;
//
//public class HomeFragment extends Fragment implements
//        View.OnClickListener,
//        IMainActivity,
//        SwipeRefreshLayout.OnRefreshListener{
//
//    public static HomeFragment newInstance() {
//        HomeFragment fragment = new HomeFragment();
//        return fragment;
//    }
//
//    private static final String TAG = "HomeFragment";
//
//    //Firebase
//    private FirebaseAuth.AuthStateListener mAuthListener; //TODO get this from main activity
//
//    //widgets
//    private FloatingActionButton mFab;
//    private RecyclerView mRecyclerView;
//    private SwipeRefreshLayout mSwipeRefreshLayout;
//
//    //variables
//    //    private Button btnLogUpdate;
//    private View mParentLayout;
//    private ArrayList<Mood> mMoods = new ArrayList<>();
//    private MoodRecyclerViewAdapter mMoodRecyclerViewAdapter;
//    private DocumentSnapshot mLastQueriedDocument;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_home,container,false);
//
//        mFab = view.findViewById(R.id.fab);
//        mParentLayout = view.findViewById(android.R.id.content);
//        mRecyclerView = view.findViewById(R.id.recycler_view);
//        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
//
//        mFab.setOnClickListener(this);
//        mSwipeRefreshLayout.setOnRefreshListener(this);
//
////        setupFirebaseAuth(); //TODO TOGGLE COMMENT
////        initRecyclerView();
////        getMoods(); //TODO TOGGLE COMMENT //CAUSES ISSUE
//
////        TODO UNCOMMENT BELOW
////        btnLogUpdate = (Button) view.findViewById(R.id.btn_log_update);
//
////        btnLogUpdate.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//////                Toast.makeText(getActivity(), "Testing button 1", Toast.LENGTH_SHORT).show();
////
////                Intent intent = new Intent(getActivity(), UpdateActivity.class);
////                startActivity(intent);
////            }
////        });
//
//        return view;
//    }
//
//
//    @Override
//    public void deleteMood(final Mood mood) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        DocumentReference moodRef = db
//                .collection("moods")
//                .document(mood.getMood_id());
//
//        moodRef.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    makeSnackBarMessage("Mood deleted");
//                    mMoodRecyclerViewAdapter.removeMood(mood);
//                }
//                else{
//                    makeSnackBarMessage("Error: Unable to delete mood");
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onRefresh() {
////        getMoods(); //TODO TOGGLE COMMENT
//        mSwipeRefreshLayout.setRefreshing(false);
//    }
////
//    private void getMoods(){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        CollectionReference moodsCollectionRef = db
//                .collection("moods");
//
//        Query moodsQuery = null;
//        if(mLastQueriedDocument != null){
//            moodsQuery = moodsCollectionRef
//                    .whereEqualTo("user_id", FirebaseAuth.getInstance().getCurrentUser().getUid())
//                    .orderBy("timestamp",Query.Direction.ASCENDING)
//                    .startAfter(mLastQueriedDocument);
//        }
//        else{
//            moodsQuery = moodsCollectionRef
//                    .whereEqualTo("user_id", FirebaseAuth.getInstance().getCurrentUser().getUid())
//                    .orderBy("timestamp", Query.Direction.ASCENDING);
//        }
//
//        moodsQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful()){
//                    for(QueryDocumentSnapshot document: task.getResult()){
//                        Mood mood = document.toObject(Mood.class);
//                        mMoods.add(mood);
////                        Log.d(TAG, "onComplete: got a new mood. Position: " + (mMoods.size() - 1));
//                    }
//                    if(task.getResult().size() !=0){
//                        mLastQueriedDocument = task.getResult().getDocuments()
//                                .get(task.getResult().size() -1);
//                    }
//                    mMoodRecyclerViewAdapter.notifyDataSetChanged();
//                }
//                else{
//                    makeSnackBarMessage("Failed to get moods.");
//                }
//            }
//        });
//    }
//
//    private void initRecyclerView(){
//        if(mMoodRecyclerViewAdapter == null){
//            mMoodRecyclerViewAdapter = new MoodRecyclerViewAdapter(this.getActivity(), mMoods);
//        }
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
//        mRecyclerView.setAdapter(mMoodRecyclerViewAdapter);
//    }
//
//    @Override
//    public void updateMood(final Mood mood) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        DocumentReference moodRef = db
//                .collection("moods")
//                .document(mood.getMood_id());
//
//        moodRef.update(
//                "title", mood.getTitle(),
//                "content", mood.getContent()
//        ).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    makeSnackBarMessage("Mood updated");
//                    mMoodRecyclerViewAdapter.updateMood(mood);
//                }
//                else{
//                    makeSnackBarMessage("Unable to update mood");
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onMoodSelected(Mood mood) {
//        ViewMoodDialog dialog =ViewMoodDialog.newInstance(mood);
//        dialog.show(getFragmentManager(), getString(R.string.dialog_view_mood));
//    }
//
//    @Override
//    public void createNewMood(String title, String content) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        DocumentReference newMoodRef = db
//                .collection("moods")
//                .document();
//
//        Mood mood = new Mood();
//        mood.setTitle(title);
//        mood.setContent(content);
//        mood.setMood_id(newMoodRef.getId());
//        mood.setUser_id(userId);
//
//        newMoodRef.set(mood).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    makeSnackBarMessage("Updated mood");
////                    getMoods();
//                }
//                else{
//                    makeSnackBarMessage("Error: Unable to update mood");
//                }
//            }
//        });
//    }
//
//    private void makeSnackBarMessage(String message){
//        Snackbar.make(mParentLayout, message, Snackbar.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch(view.getId()){
//            case R.id.fab:{
//                //create new mood
//                NewMoodDialog dialog = new NewMoodDialog();
//                dialog.show(getFragmentManager(), getString(R.string.dialog_new_mood));
//                break;
//            }
//        }
//    }
//
////menu button
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.more, menu);
////        return true;
////    }
////
////    //menu contents
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        switch (item.getItemId()) {
////            case R.id.menu_more_filter:
////                startActivity(new Intent(this, SettingsActivity.class));
////                return true;
////            case R.id.menu_more_feedback:
////                Intent Email = new Intent(Intent.ACTION_SEND);
////                Email.setType("text/email");
////                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "kevm66@gmail.com" });
////                Email.putExtra(Intent.EXTRA_SUBJECT, "Happy - Feedback");
//////                Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
////                startActivity(Intent.createChooser(Email, "Send Feedback:"));
////                return true;
////            case R.id.menu_more_settings:
////                startActivity(new Intent(this, SettingsActivity.class));
////                return true;
////            case R.id.menu_more_about:
////                startActivity(new Intent(this, SupportFragment.class));
////                return true;
////            case R.id.menu_more_log_out:
////                AuthUI.getInstance().signOut(this);
////                return true;
////            default:
////                return super.onOptionsItemSelected(item);
////        }
////    }
//}
