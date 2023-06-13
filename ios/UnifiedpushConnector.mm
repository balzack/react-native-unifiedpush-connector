#import "UnifiedpushConnector.h"

@implementation UnifiedpushConnector
RCT_EXPORT_MODULE()

RCT_REMAP_METHOD(initUnifiedPush,
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)
{
    resolve(nil);
}


// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeUnifiedpushConnectorSpecJSI>(params);
}
#endif

@end
