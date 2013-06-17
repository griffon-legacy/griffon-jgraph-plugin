
Graph visualizations and diagrams via JGraph.
---------------------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/jgraph](http://artifacts.griffon-framework.org/plugin/jgraph)


Graph visualizations and diagrams via [JGraph][1].

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*         | *Type*                               |
| -------------- | ------------------------------------ |
| graphComponent | `com.mxgraph.swing.mxGraphComponent` |
| graph          | `com.mxgraph.view.mxGraph`           |

You can call all of mxGraph's properties and methods inside it's nested child closure.

The following methods have been added to `mxGraph`

 * **applyGraphStyle(String)** - applies a graph styles that was defined using the addon's configuration script.

Configuration
-------------

Styles and shapes can be configured by placing a `GraphConfig.groovy` inside `griffon-app/conf`. This script accepts two top level
 nodes: shapes and styles.

### Example

This trivial application displays two connected nodes. The first node is drawn using a Star shape from [jSilhouette][1]. This shape and 
its related style are configured in `GraphConfig.groovy`

__griffon/app/conf/GraphConfig.groovy__
        import org.codehaus.griffon.jsilhouette.geom.Star

        shapes {
            star = new Star(50, 50, 40, 20, 5)
        }

        styles {
            STAR {
                shape = 'star'
                strokeColor = '#0000FF'
                strokeWidth = 4
                fontColor = '#0000FF'
                fillColor = '#FFFFFF'
            }
        }

__griffon-app/views/sample/SampleView.groovy
        package sample

        application(title: 'jgraph-test',
          pack: true,
          locationByPlatform:true,
          iconImage: imageIcon('/griffon-icon-48x48.png').image,
          iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                       imageIcon('/griffon-icon-32x32.png').image,
                       imageIcon('/griffon-icon-16x16.png').image]) {
            graphComponent {
                graph {
                    applyGraphStyle('STAR')
                    def v1 = insertVertex(defaultParent, null, 'Groovy', 20, 20, 80, 80, 'STAR')
                    def v2 = insertVertex(defaultParent, null, 'cool!', 200, 150, 80, 30)
                    insertEdge(defaultParent, null, 'is', v1, v2)
                }
            }
        }

[1]: http://www.jgraph.com/jgraph.html
[2]: http://griffon.codehaus.org/jsilhouette

