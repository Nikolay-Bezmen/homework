//package edu.project4;
//
//import edu.project4.DifferentThread.Render.MultiThreadRender;
//import edu.project4.ObjectOfImage.FractalHouse;
//import edu.project4.Transformations.NoLinear.CosSinSum;
//import edu.project4.Transformations.NoLinear.CosSinusoid;
//import edu.project4.Transformations.NoLinear.Disk;
//import edu.project4.Transformations.NoLinear.Polar;
//import edu.project4.Transformations.NoLinear.Sphere;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//public class FractalTesting {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        long start = System.currentTimeMillis();
//
//        start = System.currentTimeMillis();
//
////        start = System.currentTimeMillis();
////        SingleThreadRender singleRenderDrawFractalM = new SingleThreadRender(
////            new FractalHouse(1_000_00, 500, 10), 5,
////            List.of(
////                new CosSinSum(),
////                new CosSinusoid(),
//////                new RecursiveCosSin(),
////                new Disk(),
////                new Polar(),
////                new Sphere()
//////                new Sinusoidal()
////            )
////        );
//
////        singleRenderDrawFractalM.render("fractalSingle");
////        System.out.println("single thread time : " + (System.currentTimeMillis() - start));
//
//        MultiThreadRender multiThreadRender = new MultiThreadRender(
//            new FractalHouse(1_000, 500, 10), 5,
//            List.of(
//                new CosSinSum(),
//                new CosSinusoid(),
////                new RecursiveCosSin(),
//                new Disk(),
//                new Polar(),
//                new Sphere()
////                new Sinusoidal()
//            )
//        );
//
//        multiThreadRender.render("fractalMulti");
//
//        System.out.println("multi thread time : " + (System.currentTimeMillis() - start));
//    }
//}
