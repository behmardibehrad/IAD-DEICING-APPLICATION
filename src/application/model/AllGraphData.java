package application.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;




public class AllGraphData {

	private String[] spots = {"SPOT1","SPOT2","SPOT3","SPOT4","SPOT5"};
	private ObservableList<String> xAsixSpotS = FXCollections.observableArrayList();
	XYChart.Series grapg1series = new XYChart.Series();


	public AllGraphData() {
		xAsixSpotS.addAll(spots);
	}
	


	
	
	
	
	
	public XYChart.Series getGrapg1series() {
		
		return grapg1series;
	}




	public void setGrapg1series(XYChart.Series grapg1series) {
		grapg1series.setName("TYPE I");
		grapg1series.getData().add(new XYChart.Data(spots[0], 13));
	
	}
	
	
	
	
	
	
	public ObservableList<String> getxAsixSpotS() {
		return xAsixSpotS;}
	public void setxAsixSpotS(ObservableList<String> xAsixSpotS) {
		this.xAsixSpotS = xAsixSpotS;}
	
}