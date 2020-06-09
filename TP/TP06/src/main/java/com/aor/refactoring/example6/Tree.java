package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    private Date plantedAt;
    private Location location;
    private List<Date> appraisalDates;

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.location = new Location(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + location + ")";
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public Date getPlantedAt() {
        return plantedAt;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName) {
        this.location = new Location(locationLatitude, locationLongitude, locationName);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public Date latestAppraisalDate(Date today){
        Date latestAppraisalDate = today;

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }
        for(Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }
        return latestAppraisalDate;
    }

    public boolean isNextAppraisalOverdue(){

        Date today = new Date();
        Date latestAppraisalDate = latestAppraisalDate(today);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        Date nextAppraisalDate = calendar.getTime();
        // Appraisal is only overdue if its date is in the past
        return nextAppraisalDate.before(today);
    }
}
