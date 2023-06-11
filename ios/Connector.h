
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNConnectorSpec.h"

@interface Connector : NSObject <NativeConnectorSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Connector : NSObject <RCTBridgeModule>
#endif

@end
