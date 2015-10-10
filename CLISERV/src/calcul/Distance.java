package calcul;

public class Distance {
	
	public static double calcul(double[] coordA, double[] coordB){
		double rlat1 = Math.PI * coordA[0]/180;
	    double rlat2 = Math.PI * coordB[0]/180;
	 
	    double theta = coordA[1]-coordB[1];
	    double rtheta = Math.PI * theta/180;
	 
	    double dist = Math.sin(rlat1) * Math.sin(rlat2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.cos(rtheta);
	    dist = Math.acos(dist) * 180/Math.PI * 60 * 1.1515 * 1.609344 * 1000;
	    
		return dist;
	}

}
