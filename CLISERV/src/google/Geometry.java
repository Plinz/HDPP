package google;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Geometry {

 private Location location ;
 
 private String location_type;
 
 @JsonIgnore
 private Object bounds;
 
 private Viewport viewport;

 public Location getLocation() {
  return location;
 }

 public void setLocation(Location location) {
  this.location = location;
 }

 public String getLocation_type() {
  return location_type;
 }

 public void setLocation_type(String location_type) {
  this.location_type = location_type;
 }

 public Object getBounds() {
  return bounds;
 }

 public void setBounds(Object bounds) {
  this.bounds = bounds;
 }

 public Viewport getViewport() {
  return viewport;
 }

 public void setViewport(Viewport viewport) {
  this.viewport = viewport;
 }
 
}
