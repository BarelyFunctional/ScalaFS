package org.barelyfunctional.tools.scalafs

object Extras {
  implicit class EntryExtras(entry : Entry) {

  }

  implicit class DirectoryExtras(dir : Directory) {


  }

  implicit class FileExtras(file : File) {
    def contentAsString : String = ???
  }
}
