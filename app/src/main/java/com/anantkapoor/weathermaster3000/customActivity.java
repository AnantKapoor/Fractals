package com.anantkapoor.weathermaster3000;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class customActivity extends AppCompatActivity {

    public String TAG = MapsActivity.class.getSimpleName();
    public ListView lv;

    private ArrayList<HashMap<String, String>> statusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tweet Feed");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        statusList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.listA);

        new GetStatuses().execute();
    }

    public class GetStatuses extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {

            String jsonStr = "{\n" +
                    "  \"statuses\":  [\n" +
                    "     {\n" +
                    "      \"created_at\": \"Sun Mar 12 19:35:12 +0000 2017\",\n" +
                    "      \"id\": 841009700976115700,\n" +
                    "      \"id_str\": \"841009700976115712\",\n" +
                    "      \"text\": \"#Birmingham Mar 12 19:20 Temperature 9C cloudy Wind NW 26 km/h Humidity 85% weather UK .. https://t.co/pxAw8mNeTc\",\n" +
                    "      \"truncated\": false,\n" +
                    "      \"entities\":  {\n" +
                    "        \"hashtags\":  [\n" +
                    "           {\n" +
                    "            \"text\": \"Birmingham\",\n" +
                    "            \"indices\":  [\n" +
                    "              0,\n" +
                    "              11\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"symbols\":  [],\n" +
                    "        \"user_mentions\":  [],\n" +
                    "        \"urls\":  [\n" +
                    "           {\n" +
                    "            \"url\": \"https://t.co/pxAw8mNeTc\",\n" +
                    "            \"expanded_url\": \"http://bit.ly/eQNOA1\",\n" +
                    "            \"display_url\": \"bit.ly/eQNOA1\",\n" +
                    "            \"indices\":  [\n" +
                    "              91,\n" +
                    "              114\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      \"metadata\":  {\n" +
                    "        \"iso_language_code\": \"en\",\n" +
                    "        \"result_type\": \"recent\"\n" +
                    "      },\n" +
                    "      \"in_reply_to_status_id\": null,\n" +
                    "      \"in_reply_to_status_id_str\": null,\n" +
                    "      \"in_reply_to_user_id\": null,\n" +
                    "      \"in_reply_to_user_id_str\": null,\n" +
                    "      \"in_reply_to_screen_name\": null,\n" +
                    "      \"user\":  {\n" +
                    "        \"id\": 286243566,\n" +
                    "        \"id_str\": \"286243566\",\n" +
                    "        \"name\": \"Weather Birmingham\",\n" +
                    "        \"screen_name\": \"wx_birmingham\",\n" +
                    "        \"location\": \"Birmingham, England\",\n" +
                    "        \"description\": \"Weather Birmingham\",\n" +
                    "        \"url\": \"http://t.co/E5XGR8vdKn\",\n" +
                    "        \"entities\":  {\n" +
                    "          \"url\":  {\n" +
                    "            \"urls\":  [\n" +
                    "               {\n" +
                    "                \"url\": \"http://t.co/E5XGR8vdKn\",\n" +
                    "                \"expanded_url\": \"http://www.weatheronline.co.uk/UnitedKingdom/Birmingham.htm\",\n" +
                    "                \"display_url\": \"weatheronline.co.uk/UnitedKingdom/…\",\n" +
                    "                \"indices\":  [\n" +
                    "                  0,\n" +
                    "                  22\n" +
                    "                ]\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          \"description\":  {\n" +
                    "            \"urls\":  []\n" +
                    "          }\n" +
                    "        },\n" +
                    "        \"protected\": false,\n" +
                    "        \"followers_count\": 43,\n" +
                    "        \"friends_count\": 0,\n" +
                    "        \"listed_count\": 9,\n" +
                    "        \"created_at\": \"Fri Apr 22 16:29:57 +0000 2011\",\n" +
                    "        \"favourites_count\": 0,\n" +
                    "        \"utc_offset\": 0,\n" +
                    "        \"time_zone\": \"London\",\n" +
                    "        \"geo_enabled\": false,\n" +
                    "        \"verified\": false,\n" +
                    "        \"statuses_count\": 83502,\n" +
                    "        \"lang\": \"en\",\n" +
                    "        \"contributors_enabled\": false,\n" +
                    "        \"is_translator\": false,\n" +
                    "        \"is_translation_enabled\": false,\n" +
                    "        \"profile_background_color\": \"C0DEED\",\n" +
                    "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                    "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                    "        \"profile_background_tile\": false,\n" +
                    "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1321301267/WO-20px-linien_normal.png\",\n" +
                    "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1321301267/WO-20px-linien_normal.png\",\n" +
                    "        \"profile_link_color\": \"1DA1F2\",\n" +
                    "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
                    "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
                    "        \"profile_text_color\": \"333333\",\n" +
                    "        \"profile_use_background_image\": true,\n" +
                    "        \"has_extended_profile\": false,\n" +
                    "        \"default_profile\": true,\n" +
                    "        \"default_profile_image\": false,\n" +
                    "        \"following\": false,\n" +
                    "        \"follow_request_sent\": false,\n" +
                    "        \"notifications\": false,\n" +
                    "        \"translator_type\": \"none\"\n" +
                    "      },\n" +
                    "      \"geo\": null,\n" +
                    "      \"coordinates\": null,\n" +
                    "      \"place\": null,\n" +
                    "      \"contributors\": null,\n" +
                    "      \"is_quote_status\": false,\n" +
                    "      \"retweet_count\": 0,\n" +
                    "      \"favorite_count\": 0,\n" +
                    "      \"favorited\": false,\n" +
                    "      \"retweeted\": false,\n" +
                    "      \"possibly_sensitive\": false,\n" +
                    "      \"lang\": \"en\"\n" +
                    "    },\n" +
                    "     {\n" +
                    "      \"created_at\": \"Sun Mar 12 19:23:12 +0000 2017\",\n" +
                    "      \"id\": 841006680557178900,\n" +
                    "      \"id_str\": \"841006680557178880\",\n" +
                    "      \"text\": \"Our team had a great weekend eventing at #OasbyHT and the weather stayed for us too! https://t.co/B94yXzNCnq\",\n" +
                    "      \"truncated\": false,\n" +
                    "      \"entities\":  {\n" +
                    "        \"hashtags\":  [\n" +
                    "           {\n" +
                    "            \"text\": \"OasbyHT\",\n" +
                    "            \"indices\":  [\n" +
                    "              41,\n" +
                    "              49\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"symbols\":  [],\n" +
                    "        \"user_mentions\":  [],\n" +
                    "        \"urls\":  [],\n" +
                    "        \"media\":  [\n" +
                    "           {\n" +
                    "            \"id\": 841006667613499400,\n" +
                    "            \"id_str\": \"841006667613499393\",\n" +
                    "            \"indices\":  [\n" +
                    "              85,\n" +
                    "              108\n" +
                    "            ],\n" +
                    "            \"media_url\": \"http://pbs.twimg.com/tweet_video_thumb/C6vbG7zWcAECgJl.jpg\",\n" +
                    "            \"media_url_https\": \"https://pbs.twimg.com/tweet_video_thumb/C6vbG7zWcAECgJl.jpg\",\n" +
                    "            \"url\": \"https://t.co/B94yXzNCnq\",\n" +
                    "            \"display_url\": \"pic.twitter.com/B94yXzNCnq\",\n" +
                    "            \"expanded_url\": \"https://twitter.com/handcshow2017/status/841006680557178880/photo/1\",\n" +
                    "            \"type\": \"photo\",\n" +
                    "            \"sizes\":  {\n" +
                    "              \"small\":  {\n" +
                    "                \"w\": 340,\n" +
                    "                \"h\": 299,\n" +
                    "                \"resize\": \"fit\"\n" +
                    "              },\n" +
                    "              \"medium\":  {\n" +
                    "                \"w\": 400,\n" +
                    "                \"h\": 352,\n" +
                    "                \"resize\": \"fit\"\n" +
                    "              },\n" +
                    "              \"large\":  {\n" +
                    "                \"w\": 400,\n" +
                    "                \"h\": 352,\n" +
                    "                \"resize\": \"fit\"\n" +
                    "              },\n" +
                    "              \"thumb\":  {\n" +
                    "                \"w\": 150,\n" +
                    "                \"h\": 150,\n" +
                    "                \"resize\": \"crop\"\n" +
                    "              }\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      \"extended_entities\":  {\n" +
                    "        \"media\":  [\n" +
                    "           {\n" +
                    "            \"id\": 841006667613499400,\n" +
                    "            \"id_str\": \"841006667613499393\",\n" +
                    "            \"indices\":  [\n" +
                    "              85,\n" +
                    "              108\n" +
                    "            ],\n" +
                    "            \"media_url\": \"http://pbs.twimg.com/tweet_video_thumb/C6vbG7zWcAECgJl.jpg\",\n" +
                    "            \"media_url_https\": \"https://pbs.twimg.com/tweet_video_thumb/C6vbG7zWcAECgJl.jpg\",\n" +
                    "            \"url\": \"https://t.co/B94yXzNCnq\",\n" +
                    "            \"display_url\": \"pic.twitter.com/B94yXzNCnq\",\n" +
                    "            \"expanded_url\": \"https://twitter.com/handcshow2017/status/841006680557178880/photo/1\",\n" +
                    "            \"type\": \"animated_gif\",\n" +
                    "            \"sizes\":  {\n" +
                    "              \"small\":  {\n" +
                    "                \"w\": 340,\n" +
                    "                \"h\": 299,\n" +
                    "                \"resize\": \"fit\"\n" +
                    "              },\n" +
                    "              \"medium\":  {\n" +
                    "                \"w\": 400,\n" +
                    "                \"h\": 352,\n" +
                    "                \"resize\": \"fit\"\n" +
                    "              },\n" +
                    "              \"large\":  {\n" +
                    "                \"w\": 400,\n" +
                    "                \"h\": 352,\n" +
                    "                \"resize\": \"fit\"\n" +
                    "              },\n" +
                    "              \"thumb\":  {\n" +
                    "                \"w\": 150,\n" +
                    "                \"h\": 150,\n" +
                    "                \"resize\": \"crop\"\n" +
                    "              }\n" +
                    "            },\n" +
                    "            \"video_info\":  {\n" +
                    "              \"aspect_ratio\":  [\n" +
                    "                25,\n" +
                    "                22\n" +
                    "              ],\n" +
                    "              \"variants\":  [\n" +
                    "                 {\n" +
                    "                  \"bitrate\": 0,\n" +
                    "                  \"content_type\": \"video/mp4\",\n" +
                    "                  \"url\": \"https://video.twimg.com/tweet_video/C6vbG7zWcAECgJl.mp4\"\n" +
                    "                }\n" +
                    "              ]\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      \"metadata\":  {\n" +
                    "        \"iso_language_code\": \"en\",\n" +
                    "        \"result_type\": \"recent\"\n" +
                    "      },\n" +
                    "      \"in_reply_to_status_id\": null,\n" +
                    "      \"in_reply_to_status_id_str\": null,\n" +
                    "      \"in_reply_to_user_id\": null,\n" +
                    "      \"in_reply_to_user_id_str\": null,\n" +
                    "      \"in_reply_to_screen_name\": null,\n" +
                    "      \"user\":  {\n" +
                    "        \"id\": 839105226661576700,\n" +
                    "        \"id_str\": \"839105226661576704\",\n" +
                    "        \"name\": \"Horse & Country Show\",\n" +
                    "        \"screen_name\": \"handcshow2017\",\n" +
                    "        \"location\": \"Birmingham, England\",\n" +
                    "        \"description\": \"The annual Horse and Country Christmas show hosted at the Birmingham NEC. 16th & 17th December 2017\",\n" +
                    "        \"url\": null,\n" +
                    "        \"entities\":  {\n" +
                    "          \"description\":  {\n" +
                    "            \"urls\":  []\n" +
                    "          }\n" +
                    "        },\n" +
                    "        \"protected\": false,\n" +
                    "        \"followers_count\": 1188,\n" +
                    "        \"friends_count\": 31,\n" +
                    "        \"listed_count\": 0,\n" +
                    "        \"created_at\": \"Tue Mar 07 13:27:30 +0000 2017\",\n" +
                    "        \"favourites_count\": 0,\n" +
                    "        \"utc_offset\": null,\n" +
                    "        \"time_zone\": null,\n" +
                    "        \"geo_enabled\": false,\n" +
                    "        \"verified\": false,\n" +
                    "        \"statuses_count\": 4,\n" +
                    "        \"lang\": \"en-gb\",\n" +
                    "        \"contributors_enabled\": false,\n" +
                    "        \"is_translator\": false,\n" +
                    "        \"is_translation_enabled\": false,\n" +
                    "        \"profile_background_color\": \"F5F8FA\",\n" +
                    "        \"profile_background_image_url\": null,\n" +
                    "        \"profile_background_image_url_https\": null,\n" +
                    "        \"profile_background_tile\": false,\n" +
                    "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/839109397125152770/qBRVvprV_normal.jpg\",\n" +
                    "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/839109397125152770/qBRVvprV_normal.jpg\",\n" +
                    "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/839105226661576704/1489346721\",\n" +
                    "        \"profile_link_color\": \"1DA1F2\",\n" +
                    "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
                    "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
                    "        \"profile_text_color\": \"333333\",\n" +
                    "        \"profile_use_background_image\": true,\n" +
                    "        \"has_extended_profile\": false,\n" +
                    "        \"default_profile\": true,\n" +
                    "        \"default_profile_image\": false,\n" +
                    "        \"following\": false,\n" +
                    "        \"follow_request_sent\": false,\n" +
                    "        \"notifications\": false,\n" +
                    "        \"translator_type\": \"none\"\n" +
                    "      },\n" +
                    "      \"geo\": null,\n" +
                    "      \"coordinates\": null,\n" +
                    "      \"place\": null,\n" +
                    "      \"contributors\": null,\n" +
                    "      \"is_quote_status\": false,\n" +
                    "      \"retweet_count\": 0,\n" +
                    "      \"favorite_count\": 0,\n" +
                    "      \"favorited\": false,\n" +
                    "      \"retweeted\": false,\n" +
                    "      \"possibly_sensitive\": false,\n" +
                    "      \"lang\": \"en\"\n" +
                    "    },\n" +
                    "     {\n" +
                    "      \"created_at\": \"Sun Mar 12 19:14:50 +0000 2017\",\n" +
                    "      \"id\": 841004576178335700,\n" +
                    "      \"id_str\": \"841004576178335745\",\n" +
                    "      \"text\": \"Iridium flare: magnitude 1.0 at 19:43:39, altitude 52°, in direction 114° (ESE), from Iridium 23. Weather: Partly Cloudy.\",\n" +
                    "      \"truncated\": false,\n" +
                    "      \"entities\":  {\n" +
                    "        \"hashtags\":  [],\n" +
                    "        \"symbols\":  [],\n" +
                    "        \"user_mentions\":  [],\n" +
                    "        \"urls\":  []\n" +
                    "      },\n" +
                    "      \"metadata\":  {\n" +
                    "        \"iso_language_code\": \"en\",\n" +
                    "        \"result_type\": \"recent\"\n" +
                    "      },\n" +
                    "      \"in_reply_to_status_id\": null,\n" +
                    "      \"in_reply_to_status_id_str\": null,\n" +
                    "      \"in_reply_to_user_id\": null,\n" +
                    "      \"in_reply_to_user_id_str\": null,\n" +
                    "      \"in_reply_to_screen_name\": null,\n" +
                    "      \"user\":  {\n" +
                    "        \"id\": 65349164,\n" +
                    "        \"id_str\": \"65349164\",\n" +
                    "        \"name\": \"Heavens Above - Brum\",\n" +
                    "        \"screen_name\": \"abovebrum\",\n" +
                    "        \"location\": \"Birmingham, UK\",\n" +
                    "        \"description\": \"Iridium flares and ISS flybys over Birmingham, UK\",\n" +
                    "        \"url\": \"http://t.co/cI88zaoBse\",\n" +
                    "        \"entities\":  {\n" +
                    "          \"url\":  {\n" +
                    "            \"urls\":  [\n" +
                    "               {\n" +
                    "                \"url\": \"http://t.co/cI88zaoBse\",\n" +
                    "                \"expanded_url\": \"http://www.dracos.co.uk/play/above-brum/\",\n" +
                    "                \"display_url\": \"dracos.co.uk/play/above-bru…\",\n" +
                    "                \"indices\":  [\n" +
                    "                  0,\n" +
                    "                  22\n" +
                    "                ]\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          \"description\":  {\n" +
                    "            \"urls\":  []\n" +
                    "          }\n" +
                    "        },\n" +
                    "        \"protected\": false,\n" +
                    "        \"followers_count\": 66,\n" +
                    "        \"friends_count\": 6,\n" +
                    "        \"listed_count\": 4,\n" +
                    "        \"created_at\": \"Thu Aug 13 12:17:46 +0000 2009\",\n" +
                    "        \"favourites_count\": 0,\n" +
                    "        \"utc_offset\": 0,\n" +
                    "        \"time_zone\": \"London\",\n" +
                    "        \"geo_enabled\": false,\n" +
                    "        \"verified\": false,\n" +
                    "        \"statuses_count\": 8967,\n" +
                    "        \"lang\": \"en\",\n" +
                    "        \"contributors_enabled\": false,\n" +
                    "        \"is_translator\": false,\n" +
                    "        \"is_translation_enabled\": false,\n" +
                    "        \"profile_background_color\": \"0099B9\",\n" +
                    "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme4/bg.gif\",\n" +
                    "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme4/bg.gif\",\n" +
                    "        \"profile_background_tile\": false,\n" +
                    "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/360434440/Iridium-Flare_normal.jpg\",\n" +
                    "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/360434440/Iridium-Flare_normal.jpg\",\n" +
                    "        \"profile_link_color\": \"0099B9\",\n" +
                    "        \"profile_sidebar_border_color\": \"5ED4DC\",\n" +
                    "        \"profile_sidebar_fill_color\": \"95E8EC\",\n" +
                    "        \"profile_text_color\": \"3C3940\",\n" +
                    "        \"profile_use_background_image\": true,\n" +
                    "        \"has_extended_profile\": false,\n" +
                    "        \"default_profile\": false,\n" +
                    "        \"default_profile_image\": false,\n" +
                    "        \"following\": false,\n" +
                    "        \"follow_request_sent\": false,\n" +
                    "        \"notifications\": false,\n" +
                    "        \"translator_type\": \"none\"\n" +
                    "      },\n" +
                    "      \"geo\": null,\n" +
                    "      \"coordinates\": null,\n" +
                    "      \"place\": null,\n" +
                    "      \"contributors\": null,\n" +
                    "      \"is_quote_status\": false,\n" +
                    "      \"retweet_count\": 0,\n" +
                    "      \"favorite_count\": 0,\n" +
                    "      \"favorited\": false,\n" +
                    "      \"retweeted\": false,\n" +
                    "      \"lang\": \"en\"\n" +
                    "    },\n" +
                    "     {\n" +
                    "      \"created_at\": \"Sun Mar 12 19:05:31 +0000 2017\",\n" +
                    "      \"id\": 841002230270550000,\n" +
                    "      \"id_str\": \"841002230270550016\",\n" +
                    "      \"text\": \"#Birmingham Mar 12 18:50 Temperature 10C overcast Wind NW 22 km/h Humidity 85% weather UK .. https://t.co/pxAw8mNeTc\",\n" +
                    "      \"truncated\": false,\n" +
                    "      \"entities\":  {\n" +
                    "        \"hashtags\":  [\n" +
                    "           {\n" +
                    "            \"text\": \"Birmingham\",\n" +
                    "            \"indices\":  [\n" +
                    "              0,\n" +
                    "              11\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"symbols\":  [],\n" +
                    "        \"user_mentions\":  [],\n" +
                    "        \"urls\":  [\n" +
                    "           {\n" +
                    "            \"url\": \"https://t.co/pxAw8mNeTc\",\n" +
                    "            \"expanded_url\": \"http://bit.ly/eQNOA1\",\n" +
                    "            \"display_url\": \"bit.ly/eQNOA1\",\n" +
                    "            \"indices\":  [\n" +
                    "              94,\n" +
                    "              117\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      \"metadata\":  {\n" +
                    "        \"iso_language_code\": \"en\",\n" +
                    "        \"result_type\": \"recent\"\n" +
                    "      },\n" +
                    "      \"in_reply_to_status_id\": null,\n" +
                    "      \"in_reply_to_status_id_str\": null,\n" +
                    "      \"in_reply_to_user_id\": null,\n" +
                    "      \"in_reply_to_user_id_str\": null,\n" +
                    "      \"in_reply_to_screen_name\": null,\n" +
                    "      \"user\":  {\n" +
                    "        \"id\": 286243566,\n" +
                    "        \"id_str\": \"286243566\",\n" +
                    "        \"name\": \"Weather Birmingham\",\n" +
                    "        \"screen_name\": \"wx_birmingham\",\n" +
                    "        \"location\": \"Birmingham, England\",\n" +
                    "        \"description\": \"Weather Birmingham\",\n" +
                    "        \"url\": \"http://t.co/E5XGR8vdKn\",\n" +
                    "        \"entities\":  {\n" +
                    "          \"url\":  {\n" +
                    "            \"urls\":  [\n" +
                    "               {\n" +
                    "                \"url\": \"http://t.co/E5XGR8vdKn\",\n" +
                    "                \"expanded_url\": \"http://www.weatheronline.co.uk/UnitedKingdom/Birmingham.htm\",\n" +
                    "                \"display_url\": \"weatheronline.co.uk/UnitedKingdom/…\",\n" +
                    "                \"indices\":  [\n" +
                    "                  0,\n" +
                    "                  22\n" +
                    "                ]\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          \"description\":  {\n" +
                    "            \"urls\":  []\n" +
                    "          }\n" +
                    "        },\n" +
                    "        \"protected\": false,\n" +
                    "        \"followers_count\": 43,\n" +
                    "        \"friends_count\": 0,\n" +
                    "        \"listed_count\": 9,\n" +
                    "        \"created_at\": \"Fri Apr 22 16:29:57 +0000 2011\",\n" +
                    "        \"favourites_count\": 0,\n" +
                    "        \"utc_offset\": 0,\n" +
                    "        \"time_zone\": \"London\",\n" +
                    "        \"geo_enabled\": false,\n" +
                    "        \"verified\": false,\n" +
                    "        \"statuses_count\": 83502,\n" +
                    "        \"lang\": \"en\",\n" +
                    "        \"contributors_enabled\": false,\n" +
                    "        \"is_translator\": false,\n" +
                    "        \"is_translation_enabled\": false,\n" +
                    "        \"profile_background_color\": \"C0DEED\",\n" +
                    "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                    "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                    "        \"profile_background_tile\": false,\n" +
                    "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1321301267/WO-20px-linien_normal.png\",\n" +
                    "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1321301267/WO-20px-linien_normal.png\",\n" +
                    "        \"profile_link_color\": \"1DA1F2\",\n" +
                    "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
                    "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
                    "        \"profile_text_color\": \"333333\",\n" +
                    "        \"profile_use_background_image\": true,\n" +
                    "        \"has_extended_profile\": false,\n" +
                    "        \"default_profile\": true,\n" +
                    "        \"default_profile_image\": false,\n" +
                    "        \"following\": false,\n" +
                    "        \"follow_request_sent\": false,\n" +
                    "        \"notifications\": false,\n" +
                    "        \"translator_type\": \"none\"\n" +
                    "      },\n" +
                    "      \"geo\": null,\n" +
                    "      \"coordinates\": null,\n" +
                    "      \"place\": null,\n" +
                    "      \"contributors\": null,\n" +
                    "      \"is_quote_status\": false,\n" +
                    "      \"retweet_count\": 0,\n" +
                    "      \"favorite_count\": 0,\n" +
                    "      \"favorited\": false,\n" +
                    "      \"retweeted\": false,\n" +
                    "      \"possibly_sensitive\": false,\n" +
                    "      \"lang\": \"en\"\n" +
                    "    },\n" +
                    "     {\n" +
                    "      \"created_at\": \"Sun Mar 12 18:35:14 +0000 2017\",\n" +
                    "      \"id\": 840994608758833200,\n" +
                    "      \"id_str\": \"840994608758833153\",\n" +
                    "      \"text\": \"#Birmingham Mar 12 18:20 Temperature 10C clouds Wind NW 26 km/h Humidity 80% weather UK .. https://t.co/pxAw8mNeTc\",\n" +
                    "      \"truncated\": false,\n" +
                    "      \"entities\":  {\n" +
                    "        \"hashtags\":  [\n" +
                    "           {\n" +
                    "            \"text\": \"Birmingham\",\n" +
                    "            \"indices\":  [\n" +
                    "              0,\n" +
                    "              11\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"symbols\":  [],\n" +
                    "        \"user_mentions\":  [],\n" +
                    "        \"urls\":  [\n" +
                    "           {\n" +
                    "            \"url\": \"https://t.co/pxAw8mNeTc\",\n" +
                    "            \"expanded_url\": \"http://bit.ly/eQNOA1\",\n" +
                    "            \"display_url\": \"bit.ly/eQNOA1\",\n" +
                    "            \"indices\":  [\n" +
                    "              92,\n" +
                    "              115\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      \"metadata\":  {\n" +
                    "        \"iso_language_code\": \"en\",\n" +
                    "        \"result_type\": \"recent\"\n" +
                    "      },\n" +
                    "      \"in_reply_to_status_id\": null,\n" +
                    "      \"in_reply_to_status_id_str\": null,\n" +
                    "      \"in_reply_to_user_id\": null,\n" +
                    "      \"in_reply_to_user_id_str\": null,\n" +
                    "      \"in_reply_to_screen_name\": null,\n" +
                    "      \"user\":  {\n" +
                    "        \"id\": 286243566,\n" +
                    "        \"id_str\": \"286243566\",\n" +
                    "        \"name\": \"Weather Birmingham\",\n" +
                    "        \"screen_name\": \"wx_birmingham\",\n" +
                    "        \"location\": \"Birmingham, England\",\n" +
                    "        \"description\": \"Weather Birmingham\",\n" +
                    "        \"url\": \"http://t.co/E5XGR8vdKn\",\n" +
                    "        \"entities\":  {\n" +
                    "          \"url\":  {\n" +
                    "            \"urls\":  [\n" +
                    "               {\n" +
                    "                \"url\": \"http://t.co/E5XGR8vdKn\",\n" +
                    "                \"expanded_url\": \"http://www.weatheronline.co.uk/UnitedKingdom/Birmingham.htm\",\n" +
                    "                \"display_url\": \"weatheronline.co.uk/UnitedKingdom/…\",\n" +
                    "                \"indices\":  [\n" +
                    "                  0,\n" +
                    "                  22\n" +
                    "                ]\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          \"description\":  {\n" +
                    "            \"urls\":  []\n" +
                    "          }\n" +
                    "        },\n" +
                    "        \"protected\": false,\n" +
                    "        \"followers_count\": 43,\n" +
                    "        \"friends_count\": 0,\n" +
                    "        \"listed_count\": 9,\n" +
                    "        \"created_at\": \"Fri Apr 22 16:29:57 +0000 2011\",\n" +
                    "        \"favourites_count\": 0,\n" +
                    "        \"utc_offset\": 0,\n" +
                    "        \"time_zone\": \"London\",\n" +
                    "        \"geo_enabled\": false,\n" +
                    "        \"verified\": false,\n" +
                    "        \"statuses_count\": 83502,\n" +
                    "        \"lang\": \"en\",\n" +
                    "        \"contributors_enabled\": false,\n" +
                    "        \"is_translator\": false,\n" +
                    "        \"is_translation_enabled\": false,\n" +
                    "        \"profile_background_color\": \"C0DEED\",\n" +
                    "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                    "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
                    "        \"profile_background_tile\": false,\n" +
                    "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1321301267/WO-20px-linien_normal.png\",\n" +
                    "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1321301267/WO-20px-linien_normal.png\",\n" +
                    "        \"profile_link_color\": \"1DA1F2\",\n" +
                    "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
                    "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
                    "        \"profile_text_color\": \"333333\",\n" +
                    "        \"profile_use_background_image\": true,\n" +
                    "        \"has_extended_profile\": false,\n" +
                    "        \"default_profile\": true,\n" +
                    "        \"default_profile_image\": false,\n" +
                    "        \"following\": false,\n" +
                    "        \"follow_request_sent\": false,\n" +
                    "        \"notifications\": false,\n" +
                    "        \"translator_type\": \"none\"\n" +
                    "      },\n" +
                    "      \"geo\": null,\n" +
                    "      \"coordinates\": null,\n" +
                    "      \"place\": null,\n" +
                    "      \"contributors\": null,\n" +
                    "      \"is_quote_status\": false,\n" +
                    "      \"retweet_count\": 0,\n" +
                    "      \"favorite_count\": 0,\n" +
                    "      \"favorited\": false,\n" +
                    "      \"retweeted\": false,\n" +
                    "      \"possibly_sensitive\": false,\n" +
                    "      \"lang\": \"en\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"search_metadata\":  {\n" +
                    "    \"completed_in\": 0.026,\n" +
                    "    \"max_id\": 841009700976115700,\n" +
                    "    \"max_id_str\": \"841009700976115712\",\n" +
                    "    \"next_results\": \"?max_id=840994608758833152&q=weather&geocode=%2052.48%2C-1.86%2C10mi&count=5&include_entities=1&result_type=recent\",\n" +
                    "    \"query\": \"weather\",\n" +
                    "    \"refresh_url\": \"?since_id=841009700976115712&q=weather&geocode=%2052.48%2C-1.86%2C10mi&result_type=recent&include_entities=1\",\n" +
                    "    \"count\": 5,\n" +
                    "    \"since_id\": 0,\n" +
                    "    \"since_id_str\": \"0\"\n" +
                    "  }\n" +
                    "}";


            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray statuses = jsonObj.getJSONArray("statuses");

                Log.e(TAG, "Response from url: " + jsonStr);
                // looping through All Statuses
                for (int i = 0; i < statuses.length(); i++) {
                    JSONObject s = statuses.getJSONObject(i);

                    String date = s.getString("created_at");
                    String text = s.getString("text");


                    // User node is JSON Object
                    JSONObject user = s.getJSONObject("user");
                    String location = user.getString("location");


                    // tmp hash map for single contact
                    HashMap<String, String> status = new HashMap<>();
                    // adding each child node to HashMap key => value
                    status.put("date", date);
                    status.put("text", text);
                    status.put("location", location);

                    // adding contact to contact list
                    statusList.add(status);
                }

            }

            catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    customActivity.this, statusList,
                    R.layout.list_item, new String[]{"date", "text",
                    "location"}, new int[]{R.id.date,
                    R.id.text, R.id.location});

        /*-------------------------ERROR HERE-------------------------*/
        /*------------------------java.lang.NullPointerException: Attempt to invoke virtual method--------------------------*/
            lv.setAdapter(adapter);
        }
    }

    public ArrayList<HashMap<String, String>> getStatusList() {
        return statusList;
    }
}

