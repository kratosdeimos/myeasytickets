/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.util;

/**
 *
 * @author Âu
 */
public class ConvertTool {

    //get icon
    public static String getIcon(int i) {
        switch (i) {
            case 113:
                return "wi-day-sunny";
            case 116:
                return "wi-day-cloudy";
            case 119:
                return "wi-cloudy";
            case 122:
                return "wi-cloudy-gusts";
            case 143:
                return "wi-fog";
            case 176:
                return "wi-day-showers";
            case 179:
                return "wi-day-snow";
            case 182:
                return "wi-hail";
            case 185:
                return "wi-hail";
            case 200:
                return "wi-day-lightning";
            case 227:
                return "wi-snow";
            case 230:
                return "wi-snowflake-cold";
            case 248:
                return "wi-fog";
            case 260:
                return "wi-fog";
            case 263:
                return "wi-day-storm-showers";
            case 266:
                return "wi-storm-showers";
            case 281:
                return "wi-hail";
            case 284:
                return "wi-rain-mix";
            case 293:
                return "wi-thunderstorm";
            case 296:
                return "wi-thunderstorm";
            case 299:
                return "wi-day-rain";
            case 302:
                return "wi-rain";
            case 305:
                return "wi-day-rain";
            case 308:
                return "wi-rain";
            case 311:
                return "wi-storm-showers";
            case 314:
                return "wi-storm-showers";
            case 317:
                return "wi-storm-showers";
            case 320:
                return "wi-rain-mix";
            case 323:
                return "wi-day-snow-wind";
            case 326:
                return "wi-day-snow-wind";
            case 329:
                return "wi-snow-wind";
            case 332:
                return "wi-snow-wind";
            case 335:
                return "wi-day-snow-wind";
            case 338:
                return "wi-snowflake-cold";
            case 350:
                return "wi-sprinkle";
            case 353:
                return "wi-day-showers";
            case 356:
                return "wi-day-rain";
            case 359:
                return "wi-rain";
            case 362:
                return "wi-storm-showers";
            case 365:
                return "wi-storm-showers";
            case 368:
                return "wi-snow";
            case 371:
                return "wi-snow";
            case 374:
                return "wi-day-storm-showers";
            case 377:
                return "wi-rain-mix";
            case 386:
                return "wi-day-lightning";
            case 389:
                return "wi-lightning";
            case 392:
                return "wi-day-lightning";
            case 395:
                return "wi-day-snow-thunderstorm";

            default:
                return "wi-day-cloudy-gusts";
        }

    }
//get Text

    public static String getWindDirect(String i) {
        switch (i) {
            case "N":
                return "Bắc";
            case "NNE":
                return "Bắc đông bắc";
            case "NE":
                return "Đông bắc";
            case "ENE":
                return "Đông đông bắc";
            case "E":
                return "Đông";
            case "ESE":
                return "Đông đông nam";
            case "SE":
                return "Đông nam";
            case "SSE":
                return "Nam đông nam";
            case "S":
                return "Nam";
            case "SSW":
                return "Nam tây nam";
            case "SW":
                return "Tây nam";
            case "WSW":
                return "Tây tây nam";
            case "W":
                return "Tây";
            case "WNW":
                return "Tây tây bắc";
            case "NW":
                return "Tây bắc";
            case "NNW":
                return "Bắc tây bắc";
            default:
                return "Không xác định";
        }
    }

    //get short desc
}
