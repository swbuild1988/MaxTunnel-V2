const path = require('path')

const resolve = dir => {
    return path.join(__dirname, dir)
}

// 线上打包路径，请根据项目实际线上情况
const BASE_URL = process.env.NODE_ENV === 'production' ? '/' : '/'

module.exports = {
    baseUrl: BASE_URL,
    outputDir: 'dist', // 打包生成的生产环境构建文件的目录
    assetsDir: '', // 放置生成的静态资源路径，默认在outputDir
    indexPath: 'index.html', // 指定生成的 index.html 输入路径，默认outputDir
    pages: undefined, // 构建多页
    productionSourceMap: false, // 开启 生产环境的 source map?
    chainWebpack: config => {
        // 配置路径别名
        config.resolve.alias
            .set('@', resolve('src'))
            .set('_c', resolve('src/components'))
            const types = ["vue-modules", "vue", "normal-modules", "normal"]
            types.forEach(type =>
                addStyleResource(config.module.rule("less").oneOf(type))
            )
    },
    css: {
        modules: false, // 启用 CSS modules
        extract: true, // 是否使用css分离插件
        sourceMap: false, // 开启 CSS source maps?
        loaderOptions: {
            less: {
                javascriptEnabled: true
            },// css预设器配置项
            postcss: {
                plugins: [
                    require('postcss-pxtorem')({ // 把px单位换算成rem单位
                        rootValue: 100, // 换算的基数(设计图750的根字体为32)(需求：设计图1920根字体16)
                        selectorBlackList: ['weui', 'mu'], // 忽略转换正则匹配项
                        propList: ['*']
                    })
                ]
            }
        } // css预设器配置项
    },
    devServer: {
        port: 8080, // 端口
        proxy: 'https://www.easy-mock.com' // 设置代理
    },
    pluginOptions: {
        'style-resources-loader': {
          preProcessor: 'less',
          patterns: []
        }
      }
}
function addStyleResource(rule) {
	rule.use('style-resource')
	.loader('style-resources-loader')
	.options({
		patterns: [
			// 需要全局导入的less路径，自己修改，我这里引入了两个less文件
			path.resolve(__dirname, './src/assets/less/common.less'),
			path.resolve(__dirname, './src/assets/less/variables.less')
		],
	})
}