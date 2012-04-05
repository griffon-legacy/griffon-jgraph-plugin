/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres.Almiray
 */
class JgraphGriffonPlugin {
    // the plugin version
    String version = '0.2'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '0.9.5']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-jgraph-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Graph visualizations and diagrams via JGraph.'
    String description = '''
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
'''
}
