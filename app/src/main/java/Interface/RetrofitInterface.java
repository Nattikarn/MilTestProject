package Interface;
import com.example.mil.miltestproject.ArrayListTest3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mil on 2/14/2018 AD.
 */

public interface RetrofitInterface {
    @GET("users/{username}")
    Call<ArrayListTest3> getUser(@Path("username") String username);

    @GET("group/{id}/users")
    Call<List<ArrayListTest3>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("users/new")
    Call<ArrayListTest3> createUser(@Body ArrayListTest3 user);
}
