package org.barelyfunctional.tools.scalafs

import org.scalatest.{MustMatchers, FunSuite}

class DirectoryTest extends FunSuite with MustMatchers {
  test("can list files in a directory") {
    Directory("src/test/data").list.map(_.name) must be (List("file1.txt", "file2.txt"))
  }


}
