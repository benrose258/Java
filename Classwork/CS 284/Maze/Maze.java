package Maze;

/**
 * Class that solves maze problems with backtracking.
 * Name: Ben Rose
 * CS 284 Section B
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 */

import java.util.ArrayList;
import java.util.Stack;

public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }


    public ArrayList<ArrayList<PairInt>> findMazePath2() {
    	return findAllMazePaths(0,0);
    }

    public ArrayList<PairInt> findMazePath3() {
    	return findMazePathMin(0,0);
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */

    public boolean findMazePath(int x, int y) {
    	if (x >= maze.getNCols() || x < 0 || y >= maze.getNRows() || y < 0) {
    		return false;
    	}
    	if (maze.getColor(x, y) != NON_BACKGROUND) {
    		return false;
    	} else {
    		maze.recolor(x,y,PATH);
    		if (x+1 == maze.getNCols() && y+1 == maze.getNRows()) { // We are at the exit
	    		return true;
	    	}
    		if (!(this.findMazePath(x, y+1) || this.findMazePath(x+1,y) || this.findMazePath(x,y-1) || this.findMazePath(x-1,y))) { // If we've hit a dead end
    			maze.recolor(x,y,TEMPORARY);
    			return false;
    		} else {
    			return true;
    		}
    	}
	}

    public boolean findMazePath2(int x, int y, ArrayList<ArrayList<PairInt>> result, ArrayList<PairInt> trace, ArrayList<PairInt> badPoints) {
    	if (x >= maze.getNCols() || x < 0 || y >= maze.getNRows() || y < 0) {
    		return false;
    	}
    	if (maze.getColor(x, y) != NON_BACKGROUND) {
    		return false;
    	} else {
    		trace.add(new PairInt(x,y));
    		maze.recolor(x,y,PATH);
    		if (x+1 == maze.getNCols() && y+1 == maze.getNRows()) { // We are at the exit
    			trace.removeAll(badPoints);
    			result.add(trace);
	    		return true;
	    	}
    		if (!(this.findMazePath2(x, y+1, result, trace, badPoints) || this.findMazePath2(x+1,y, result, trace, badPoints) || this.findMazePath2(x,y-1, result, trace, badPoints) || this.findMazePath2(x-1,y, result, trace, badPoints))) { // If we've hit a dead end
    			maze.recolor(x,y,TEMPORARY);
    			badPoints.add(new PairInt(x,y));
    			return false;
    		} else {
    			this.findMazePath2(x, y+1, result, trace, badPoints);
    			this.findMazePath2(x+1,y, result, trace, badPoints);
    			this.findMazePath2(x,y-1, result, trace, badPoints);
    			this.findMazePath2(x-1,y, result, trace, badPoints);
    			return true;
    		}
    	}
	}

    /**
     * @param x: x-coordinate
     * @param y: y-coordinate
     * @param result: the list of successful paths recorded up to now
     * @param trace: the trace of the current path being explored
     */

    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		trace.push(new PairInt(x,y));
		if (x+1 == maze.getNCols() && y+1 == maze.getNRows()) { // We are at the exit
			ArrayList<PairInt> goodPath = new ArrayList<PairInt>(trace);
			result.add(goodPath);
			maze.recolor(x, y, NON_BACKGROUND);
			trace.pop();
			return;
    	}
		maze.recolor(x, y, TEMPORARY);
		if (isOpen(x, y+1)) {
			findMazePathStackBased(x, y+1, result, trace);
		}
		if (isOpen(x+1,y)) {
			findMazePathStackBased(x+1,y, result, trace);
		}
		if (isOpen(x,y-1)) {
			findMazePathStackBased(x,y-1, result, trace);
		}
		if (isOpen(x-1,y)) {
			findMazePathStackBased(x-1,y, result, trace);
		}
		maze.recolor(x, y, NON_BACKGROUND);
		trace.pop();
	}

    public boolean isOpen(int x, int y) {
    	if (x >= maze.getNCols() || x < 0 || y >= maze.getNRows() || y < 0) {
    		return false;
    	}
    	if (maze.getColor(x, y) != NON_BACKGROUND) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }

    public ArrayList<ArrayList<PairInt>> findAllMazePaths (int x, int y) {
    	ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
    	Stack<PairInt> trace = new Stack<>();
    	findMazePathStackBased(0, 0, result, trace);
    	if (result.size() == 0) {
    		result.add(new ArrayList());
    	}
    	return result;
	}

    public ArrayList<PairInt> findMazePathMin(int x, int y) {
		ArrayList<ArrayList<PairInt>> allPaths = findAllMazePaths(x,y);
		ArrayList<PairInt> result = allPaths.get(0);
		for (int i = 0; i<allPaths.size(); i++) {
			if (allPaths.get(i).size() < result.size()) {
				result = allPaths.get(i);
			}
		}
		System.out.println("All Possible Paths:\n"+allPaths+"\n\nBest Path:");
		return result;
    }

    // Demo toString method
    public String demoToString(ArrayList<ArrayList<PairInt>> allPaths) {
    	StringBuilder s = new StringBuilder();
    	for (ArrayList<PairInt> a : allPaths) {
    		s.append(a+"\n");
    	}
    	return s.toString();
    }

    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }

    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
  }
