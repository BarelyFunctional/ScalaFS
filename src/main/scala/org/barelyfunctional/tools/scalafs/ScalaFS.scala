package org.barelyfunctional.tools.scalafs

import java.io.{File => JFile, FileInputStream, InputStream}

trait Entry {
  def name : String
}

trait File extends Entry {
  def length : Long
  def content : InputStream
}

trait Directory extends Entry {
  def list : List[Entry]

  def addFile(path : List[String], content : Array[Byte]) : Directory
}

object File {
  def apply(source : JFile) = new File {
    override def name: String = source.getName

    override def content: InputStream = new FileInputStream(source)

    override def length: Long = source.length
  }
}

object Directory {
  def apply(source : String) : Directory = Directory(new JFile(source))

  def apply(source : JFile) = new Directory {
    override def name: String = source.getName

    override def list: List[Entry] = source.listFiles.toList.map(Entry.apply(_))

    override def addFile(path: List[String], content: Array[Byte]): Directory = ???
  }
}

object Entry {

  def write(to : String) {
    // TODO
  }

  def apply(file : JFile) : Entry =
    if (file.isDirectory) Directory(file)
    else File(file)

  def apply(path : String) : Entry = Entry(new JFile(path))
}

