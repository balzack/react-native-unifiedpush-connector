
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNUnifiedpushConnectorSpec.h"

@interface UnifiedpushConnector : NSObject <NativeUnifiedpushConnectorSpec>
#else
#import <React/RCTBridgeModule.h>

@interface UnifiedpushConnector : NSObject <RCTBridgeModule>
#endif

@end
