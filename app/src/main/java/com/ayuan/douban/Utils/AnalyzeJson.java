package com.ayuan.douban.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.ayuan.douban.vo.Actor;
import com.ayuan.douban.vo.Avatars;
import com.ayuan.douban.vo.Detail;
import com.ayuan.douban.vo.Directors;
import com.ayuan.douban.vo.Images;
import com.ayuan.douban.vo.Rating;
import com.ayuan.douban.vo.Subjects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnalyzeJson {
    private static final String TAG = "AnalyzeJson";

    public static ArrayList<Subjects> getMovieDetail(Context context, String jsonString) {
        if (!TextUtils.isEmpty(jsonString)) {
            try {
                JSONObject rootJsonObject = new JSONObject(jsonString);
                if (rootJsonObject.has("subjects")) {
                    ArrayList<Subjects> subjects = new ArrayList<Subjects>();
                    JSONArray subjectsArray = rootJsonObject.optJSONArray("subjects");
                    for (int i = 0; i < subjectsArray.length(); i++) {
                        JSONObject subJsonObject = subjectsArray.optJSONObject(i);
                        String alt = subJsonObject.optString("alt");

                        JSONArray casts = subJsonObject.optJSONArray("casts");
                        ArrayList<Actor> castsList = casts(casts);

                        int collect_count = subJsonObject.optInt("collect_count");

                        JSONArray directors = subJsonObject.optJSONArray("directors");
                        ArrayList<Directors> directorsList = getDirectors(directors);

                        JSONArray durations = subJsonObject.optJSONArray("durations");
                        ArrayList<String> durationList = new ArrayList<String>();
                        for (int j = 0; j < durations.length(); j++) {
                            String duration = durations.optString(j);
                            durationList.add(duration);
                        }

                        JSONArray genres = subJsonObject.optJSONArray("genres");
                        ArrayList<String> genresList = new ArrayList<>();
                        for (int k = 0; k < genres.length(); k++) {
                            String genre = genres.optString(k);
                            genresList.add(genre);
                        }

                        boolean has_video = subJsonObject.optBoolean("has_video");

                        String id = subJsonObject.optString("id");

                        JSONObject images = subJsonObject.optJSONObject("images");
                        Bitmap large = HttpGetBitmap.getBitmap(images.optString("largeg"), context);
                        Bitmap medium = HttpGetBitmap.getBitmap(images.optString("medium"), context);
                        Bitmap small = HttpGetBitmap.getBitmap(images.optString("small"), context);
                        /*String large = images.optString("large");
                        String medium = images.optString("medium");
                        String small = images.optString("small");*/
                        Images images_vo = new Images(large, medium, small);

                        String mainland_pubdate = subJsonObject.optString("mainland_pubdate");

                        String original_title = subJsonObject.optString("original_title");

                        JSONArray pubdatess = subJsonObject.optJSONArray("pubdates");
                        ArrayList<String> pubdates = new ArrayList<String>();
                        for (int h = 0; h < pubdatess.length(); h++) {
                            String s = pubdatess.optString(h);
                            pubdates.add(s);
                        }

                        JSONObject rating = subJsonObject.optJSONObject("rating");
                        double average = rating.optDouble("average");
                        JSONObject details = rating.optJSONObject("details");
                        int _1 = details.optInt("1");
                        int _2 = details.optInt("2");
                        int _3 = details.optInt("3");
                        int _4 = details.optInt("4");
                        int _5 = details.optInt("5");
                        Detail detai_vo = new Detail(_1, _2, _3, _4, _5);
                        int max = rating.optInt("max");
                        int min = rating.optInt("min");
                        int stars = rating.optInt("stars");
                        Rating rating_vo = new Rating(average, detai_vo, max, min, stars);

                        String subtype = subJsonObject.optString("subtype");
                        String title = subJsonObject.optString("title");
                        String year = subJsonObject.optString("year");

                        String title1 = rootJsonObject.optString("title");
                        int total = rootJsonObject.optInt("total");

                        Subjects subjects_vo = new Subjects(alt, castsList, collect_count, directorsList, durationList, genresList, has_video, id, images_vo, mainland_pubdate, original_title, pubdates, rating_vo, subtype, title, year, title1, total);
                        subjects.add(subjects_vo);
                    }
                    return subjects;
                } else {
                    return null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static ArrayList<Actor> casts(JSONArray casts) {
        ArrayList<Actor> actors = new ArrayList<>();
        for (int i = 0; i < casts.length(); i++) {
            JSONObject jsonObject = casts.optJSONObject(i);
            String alt = jsonObject.optString("alt");

            JSONObject avatars = jsonObject.optJSONObject("avatars");
            String large = avatars.optString("large");
            String medium = avatars.optString("medium");
            String small = avatars.optString("small");
            Avatars avatars_vo = new Avatars(large, medium, small);

            String id = jsonObject.optString("id");
            String name = jsonObject.optString("name");
            String name_en = jsonObject.optString("name_en");
            Actor actor = new Actor(alt, avatars_vo, id, name, name_en);
            actors.add(actor);
        }
        return actors;
    }

    private static ArrayList<Directors> getDirectors(JSONArray jsonArray) {
        ArrayList<Directors> directors = new ArrayList<Directors>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            String alt = jsonObject.optString("alt");

            JSONObject avatars = jsonObject.optJSONObject("avatars");
            String large = avatars.optString("large");
            String medium = avatars.optString("medium");
            String small = avatars.optString("small");
            Avatars avatars_vo = new Avatars(large, medium, small);

            String id = jsonObject.optString("id");
            String name = jsonObject.optString("name");
            String name_en = jsonObject.optString("name_en");
            Directors directorss = new Directors(alt, avatars_vo, id, name, name_en);
            directors.add(directorss);
        }
        return directors;
    }
}
