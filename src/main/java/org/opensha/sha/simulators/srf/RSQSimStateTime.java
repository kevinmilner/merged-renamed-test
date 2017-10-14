package org.opensha.sha.simulators.srf;

public class RSQSimStateTime {
	
	private final double startTime;
	private double endTime;
	private final RSQSimState state;
	
	/**
	 * Creates a state time where the end is not yet known
	 * @param startTime
	 * @param state
	 */
	RSQSimStateTime(double startTime, RSQSimState state) {
		this(startTime, Double.NaN, state);
	}
	
	public RSQSimStateTime(double startTime, double endTime, RSQSimState state) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
	}

	public double getEndTime() {
		return endTime;
	}

	void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	public double getStartTime() {
		return startTime;
	}

	public RSQSimState getState() {
		return state;
	}
	
	public double getDuration() {
		return endTime - startTime;
	}
	
	public boolean containsTime(double time) {
		return time >= startTime && time < endTime;
	}
	
	@Override
	public String toString() {
		return "["+startTime+" => "+endTime+": "+state.name()+"]";
	}

}
