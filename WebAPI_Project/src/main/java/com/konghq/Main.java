package com.konghq;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class EndpointApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        app.get("/api", ctx -> {
            String slackName = ctx.queryParam("Mary Nkoana");
            String track = ctx.queryParam("backend");
            String currentDay = java.time.DayOfWeek.from(java.time.LocalDate.now()).toString();
            String utcTime = java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC).toString();

            // Create the JSON response
            String jsonResponse = String.format(
                    "{\"slack_name\": \"%s\", \"current_day\": \"%s\", \"utc_time\": \"%s\", \"track\": \"%s\", \"github_file_url\": \"%s\", \"github_repo_url\": \"%s\", \"status_code\": %d}",
                    slackName, currentDay, utcTime, track, "https://github.com/MaryNkoana01/WebAPI/blob/main/file_name.ext",
                    "https://github.com/MaryNkoana01/WebAPI", 200
            );

            // Set response content type and status code
            ctx.contentType("application/json");
            ctx.status(200);

            // Send JSON response
            ctx.result(jsonResponse);
        });
    }
}
