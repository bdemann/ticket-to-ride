//package server.facades.helpers;
//
///**
// * Created by paulinecausse on 3/24/18.
// */
//
//public class LongestPath {
//    static int times;
//    public double initLongestPath(ArrayList<Vertex> V,Vertex source){
//        for(Vertex u:V){
//            u.setVisited(false);
//        }
//        return getLongestPath(source);
//    }
//    public double getLongestPath(Vertex v){
//        ++times;
//        System.out.println(times);
//        double w,dist,max=0;
//        v.setVisited(true);
//        for(Edge e:v.getOutGoingEdges()){
//            if(!e.getToNode().isVisited()){
//                dist=e.getWeight()+getLongestPath(e.getToNode());
//                if(dist>max)
//                    max=dist;
//            }
//        }
//
//        v.setVisited(false);
//        return max;
//}
