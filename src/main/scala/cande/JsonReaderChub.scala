package cande

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._

object JsonReaderChub extends App {

  case class Wine (id: Option[Int],
                  country: Option[String],
                  points: Option[Int],
                  price: Option[Double],
                  title: Option[String],
                  variety: Option[String],
                  winery: Option[String])

  override def main(args: Array[String]) {
    val filename = "/home/can/test/spark/winemag-data-130k-v2.json"
    println(filename)
    val conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("JsonReaderCan")
    val sparkContext = new SparkContext(conf)

    val rdd: RDD[String] = sparkContext.textFile(filename)

    val wines = rdd.map(json => {
      implicit val formats: DefaultFormats.type = DefaultFormats;
      parse(json).extract[Wine]
    }).collect()

    wines.foreach(println)
  }
}
