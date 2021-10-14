import unittest
import LCA

class TestLCA(unittest.TestCase):

    def setUp(self):
        self.root = LCA.Node(4)
        self.root.left = LCA.Node(2)
        self.root.right = LCA.Node(6)
        self.root.left.left = LCA.Node(1) 
        self.root.left.right = LCA.Node(3) 
        self.root.right.left = LCA.Node(5) 
        self.root.right.right = LCA.Node(7)

    def test_findLCA(self):

        self.assertEqual(LCA.findLCA(self.root, 4, 5), 4, "LCA(4, 5) should be 4")
        self.assertEqual(LCA.findLCA(self.root, 1, 2), 2, "LCA(1, 2) should be 2")
        self.assertEqual(LCA.findLCA(self.root, 3, 2), 2, "LCA(3, 4) should be 2")
        self.assertEqual(LCA.findLCA(self.root, 5, 7), 6, "LCA(5, 7) should be 6")

        self.assertEqual(LCA.findLCA(self.root, 4, 8), None, "LCA(4, 5) should be None")
        self.assertEqual(LCA.findLCA(self.root, 8, 4), None, "LCA(8, 4) should be None")

    def test_findLCA_DAG(self):
        graph = LCA.nx.DiGraph()
        graph.add_edges_from([(1, 2), (1, 3), (1, 4), (1, 5), (2, 4), (3, 4), (3, 5), (4, 5)])

        self.assertEqual(LCA.nx.lowest_common_ancestor(graph, 2, 3), 1, "LCA_DAG(2, 3) should be 1")
        self.assertEqual(LCA.nx.lowest_common_ancestor(graph, 2, 5), 2, "LCA_DAG(2, 3) should be 1")
        self.assertEqual(LCA.nx.lowest_common_ancestor(graph, 1, 4), 1, "LCA_DAG(2, 3) should be 1")
        self.assertEqual(LCA.nx.lowest_common_ancestor(graph, 4, 5), 4, "LCA_DAG(2, 3) should be 1")

        #self.assertRaises(LCA.nx.NodeNotFound("The node 6 is not in the digraph."), LCA.nx.lowest_common_ancestor(graph, 2, 6))

if __name__ == '__main__':
    unittest.main()